/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.geminiSystems;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author GGobozov
 */
@XmlRootElement
public class Message implements Serializable{

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }




}
