/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.concepter.utils;

import br.com.concepter.model.beans.Entidade;
import br.com.concepter.model.beans.Relacao;
import br.com.concepter.model.enuns.TipoObrigatoriedadeEnum;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author AllanMagnum
 */
public class XmlUtils<T> {
    
    public void save(T object){
        try {            
            JAXBContext jaxbContext = JAXBContext.newInstance(Entidade.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(object, System.out);

	} catch (JAXBException e) {
            e.printStackTrace();
	}
    }

    public void load(String fileName, Entidade objeto){
        try {
            File file = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(objeto.getClass());

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//            Class<T> classe = (Class<T>) jaxbUnmarshaller.unmarshal(file);
//            System.out.println(classe);

	} catch (JAXBException e) {
            e.printStackTrace();
	}

    }
 
}
