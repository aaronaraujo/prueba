/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softsimphony.checadorgdf.util;

import com.digitalpersona.uareu.Engine;
import com.digitalpersona.uareu.Fid;
import com.digitalpersona.uareu.Fmd;
import com.digitalpersona.uareu.Reader;
import com.digitalpersona.uareu.ReaderCollection;
import com.digitalpersona.uareu.UareUException;
import com.digitalpersona.uareu.UareUGlobal;
import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 *
 * @author ss
 */
public class LectorUareU {

    private Reader lectorUareU;
    private Engine engineUareU;

    public LectorUareU() throws UareUException {

        ReaderCollection lectores = UareUGlobal.GetReaderCollection();

        /*
         Busca lectores Disponibles
         */
        System.out.println("[ SYS ] Buscando lectores disponibles ...");
        lectores.GetReaders();
        while (lectores.size() == 0) {
            lectores.GetReaders();
        }
        System.out.println("[ SYS ] Lectores obtenidos");

        /*
            Se asigna el primer lector que se ha encontrado
         */
        lectorUareU = lectores.get(0);
        System.out.println("[ SYS ] Abriendo lector ...");
        lectorUareU.Open(Reader.Priority.COOPERATIVE);
        System.out.println("[ SYS ] Lector abierto");

        System.out.println("[ SYS ] Obteniendo Engine ...");
        engineUareU = UareUGlobal.GetEngine();
        System.out.println("[ SYS ] Engine Obtenido");

    }

    /**
     * Metodo que realiza la captura de la huella del lector y regresa como
     * resultodo un imagen en formato Fid
     *
     * @return
     * @throws UareUException
     */
    public Fid capturarHuella() throws UareUException {

        
        Reader.CaptureResult captureResult = lectorUareU.Capture(Fid.Format.ANSI_381_2004, 
                                                                 Reader.ImageProcessing.IMG_PROC_DEFAULT, 500, -1);
        return captureResult.image;
    }

    /**
     * Metodo que obtienen el formato BufferedImage para generar la imagen
     * (jpg,png, etc) de una huella en formato Fid
     *
     * @param formatoFidHuella
     * @return
     */
    public BufferedImage obtenerImagenHuella(Fid formatoFidHuella) {
        Fid.Fiv imagenHuellaFiv = formatoFidHuella.getViews()[0];
        BufferedImage imagenBuffered = new BufferedImage(imagenHuellaFiv.getWidth(),
                imagenHuellaFiv.getHeight(),
                BufferedImage.TYPE_BYTE_GRAY);

        imagenBuffered.getRaster().setDataElements(0, 0, imagenHuellaFiv.getWidth(),
                imagenHuellaFiv.getHeight(),
                imagenHuellaFiv.getData());

        return imagenBuffered;
    }

    /**
     * Metodo que obteiene el formato Fmd de una huella capturada, esto puede
     * servir para enrrolar a una persona y validacion de huellas.
     *
     * @param formatoFidHuella
     * @return
     * @throws UareUException
     */
    public Fmd obtenerFormatoFmd(Fid formatoFidHuella) throws UareUException {
        return engineUareU.CreateFmd(formatoFidHuella, Fmd.Format.ANSI_378_2004);
    }

    /**
     * Metodo que realiza el proceso de las 4 huellas en formato Fmd, para
     * obtener un Fmd que obteiene la huella enrrolada para posteriormente
     * validar a un usuario.
     *
     * @param huellas
     * @return
     * @throws UareUException
     */
    public Fmd obtenerFormatoEnrrolamiento(Fmd huellas[]) throws UareUException {
        Fmd fmdOriginal = engineUareU.CreateEnrollmentFmd(Fmd.Format.ANSI_378_2004, new Engine.EnrollmentCallback() {

            int i = 0;

            @Override
            public Engine.PreEnrollmentFmd GetFmd(Fmd.Format format) {
                Engine.PreEnrollmentFmd result = new Engine.PreEnrollmentFmd();
                try {
                    result.fmd = huellas[(i++) % 4];
                } catch (Exception ex) {

                    return null;
                }
                return result;
            }
        });
        return fmdOriginal;
    }

    /**
     * Metodo que obtiene el string de una huella en formato Fmd, este metodo se
     * usa cuando se termino de enrrolar, para guardar la huella en forma de
     * String.
     *
     * @param huella
     * @return
     */
    public String obtenerStringHuella(Fmd huella) {
        return new String(huella.getData(), Charset.forName("ISO-8859-1"));

    }

    /**
     * Metodo que obtiene el string de una huella en formato Fmd, este metodo se
     * usa cuando se termino de enrrolar, para guardar la huella en forma de
     * Blob.
     *
     * @param huella
     * @return
     */
    public byte[] obetenerBytesHuella(Fmd huella) {
        return huella.getData();
    }

    /**
     * Metodo que apartir de un String de una huella obtiene un formato Fmd,
     * este metodo es util cuando en la base de datos se guardaron String, para
     * poderlas comparar se necesita un formato Fmd
     *
     * @param huella
     * @return
     * @throws UareUException
     */
    public Fmd obtenerHuellaFmd(String huella) throws UareUException, UnsupportedEncodingException {
        return UareUGlobal.GetImporter().ImportFmd(huella.getBytes("ISO-8859-1"), Fmd.Format.ANSI_378_2004, Fmd.Format.ANSI_378_2004);
    }

    /**
     * Metodo que apartir de un array de bytes de una huella obtiene un formato
     * Fmd, este metodo es util cuando en la base de datos se guardaron array de
     * bytes, para poderlas comparar se necesita un formato Fmd
     *
     * @param huella
     * @return
     * @throws UareUException
     */
    public Fmd obtenerHuellaFmd(byte[] huella) throws UareUException {
        return UareUGlobal.GetImporter().ImportFmd(huella, Fmd.Format.ANSI_378_2004, Fmd.Format.ANSI_378_2004);
    }

    /**
     * Metodo para comparar dos huellas en formato Fmd, como resultado regresa
     * un boolean, false no son iguales, true son iguales.
     *
     * @param huellaOriginal // huella previamente enrrolada
     * @param huellaAComparar // huella capturada que se quiere validar
     * @return
     */
    public boolean validarHuellas(Fmd huellaOriginal, Fmd huellaAComparar) throws UareUException {
        int rangoSimilitud = engineUareU.Compare(huellaAComparar, 0, huellaOriginal, 0);
        //System.out.println("Parecido de Huella: " + rangoSimilitud);
        if (rangoSimilitud < 2000) {
            return true;
        } else {
            return false;
        }
    }

}
