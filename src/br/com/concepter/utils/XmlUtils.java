/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.concepter.utils;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author AllanMagnum
 */
public class XmlUtils<T> {
    
    public void save(String fileName, Class<T> objeto){
        try {

            File file = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(objeto.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(objeto.getClass(), file);
            jaxbMarshaller.marshal(objeto.getClass(), System.out);

	} catch (JAXBException e) {
            e.printStackTrace();
	}
    }

    public void load(String fileName, Class<T> objeto){
        try {
            File file = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(objeto.getClass());

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Class<T> classe = (Class<T>) jaxbUnmarshaller.unmarshal(file);
            System.out.println(classe);

	} catch (JAXBException e) {
            e.printStackTrace();
	}

    }
 
}
