package com.cox.bis.customer.comments.icoms.response;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "ERROR")
public class ERROR {

    @XmlAttribute(name = "_RC", required = true)
    protected BigInteger rc;
    @XmlAttribute(name = "_MQQ", required = true)
    protected BigInteger mqq;
    @XmlAttribute(name = "_MSGNO", required = true)
    protected String msgno;
    @XmlAttribute(name = "_MSGTEXT", required = true)
    protected String msgtext;
    @XmlAttribute(name = "_BERC")
    protected BigInteger berc;

    
    public BigInteger getRC() {
        return rc;
    }

    
    public void setRC(BigInteger value) {
        this.rc = value;
    }

    
    public BigInteger getMQQ() {
        return mqq;
    }

    
    public void setMQQ(BigInteger value) {
        this.mqq = value;
    }

    
    public String getMSGNO() {
    	return msgno;
    }

    public void setMSGNO(String value) {
        this.msgno = value;
    }
    
    public void setMSGNO(BigInteger value) {
    	if(value!=null) this.msgno=value.toString();
    	else this.msgno = new String();
    }

    public void setMSGNO(Object value) {
    	if(value!=null) this.msgno=value.toString();
    	else this.msgno = new String();
    }
    
    public String getMSGTEXT() {
        return msgtext;
    }

    
    public void setMSGTEXT(String value) {
        this.msgtext = value;
    }

    
    public BigInteger getBERC() {
        return berc;
    }

    
    public void setBERC(BigInteger value) {
        this.berc = value;
    }

}