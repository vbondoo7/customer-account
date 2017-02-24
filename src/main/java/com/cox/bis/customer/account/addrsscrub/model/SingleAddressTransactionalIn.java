
package com.cox.bis.customer.account.addrsscrub.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://businessobjects.com/service/SingleAddressTransactional/input}address1"/>
 *         &lt;element ref="{http://businessobjects.com/service/SingleAddressTransactional/input}address2"/>
 *         &lt;element ref="{http://businessobjects.com/service/SingleAddressTransactional/input}address3"/>
 *         &lt;element ref="{http://businessobjects.com/service/SingleAddressTransactional/input}address4"/>
 *         &lt;element ref="{http://businessobjects.com/service/SingleAddressTransactional/input}address5"/>
 *         &lt;element ref="{http://businessobjects.com/service/SingleAddressTransactional/input}address6"/>
 *         &lt;element ref="{http://businessobjects.com/service/SingleAddressTransactional/input}address7"/>
 *         &lt;element ref="{http://businessobjects.com/service/SingleAddressTransactional/input}address8"/>
 *         &lt;element ref="{http://businessobjects.com/service/SingleAddressTransactional/input}country"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "address1",
    "address2",
    "address3",
    "address4",
    "address5",
    "address6",
    "address7",
    "address8",
    "country"
})
@XmlRootElement(name = "SingleAddressTransactionalIn", namespace = "http://businessobjects.com/service/SingleAddressTransactional/input")
public class SingleAddressTransactionalIn {

    @XmlElement(namespace = "http://businessobjects.com/service/SingleAddressTransactional/input", required = true)
    protected String address1;
    @XmlElement(namespace = "http://businessobjects.com/service/SingleAddressTransactional/input", required = true)
    protected String address2;
    @XmlElement(namespace = "http://businessobjects.com/service/SingleAddressTransactional/input", required = true)
    protected String address3;
    @XmlElement(namespace = "http://businessobjects.com/service/SingleAddressTransactional/input", required = true)
    protected String address4;
    @XmlElement(namespace = "http://businessobjects.com/service/SingleAddressTransactional/input", required = true)
    protected String address5;
    @XmlElement(namespace = "http://businessobjects.com/service/SingleAddressTransactional/input", required = true)
    protected String address6;
    @XmlElement(namespace = "http://businessobjects.com/service/SingleAddressTransactional/input", required = true)
    protected String address7;
    @XmlElement(namespace = "http://businessobjects.com/service/SingleAddressTransactional/input", required = true)
    protected String address8;
    @XmlElement(namespace = "http://businessobjects.com/service/SingleAddressTransactional/input", required = true)
    protected String country;

    /**
     * Gets the value of the address1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * Sets the value of the address1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress1(String value) {
        this.address1 = value;
    }

    /**
     * Gets the value of the address2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * Sets the value of the address2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress2(String value) {
        this.address2 = value;
    }

    /**
     * Gets the value of the address3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress3() {
        return address3;
    }

    /**
     * Sets the value of the address3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress3(String value) {
        this.address3 = value;
    }

    /**
     * Gets the value of the address4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress4() {
        return address4;
    }

    /**
     * Sets the value of the address4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress4(String value) {
        this.address4 = value;
    }

    /**
     * Gets the value of the address5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress5() {
        return address5;
    }

    /**
     * Sets the value of the address5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress5(String value) {
        this.address5 = value;
    }

    /**
     * Gets the value of the address6 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress6() {
        return address6;
    }

    /**
     * Sets the value of the address6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress6(String value) {
        this.address6 = value;
    }

    /**
     * Gets the value of the address7 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress7() {
        return address7;
    }

    /**
     * Sets the value of the address7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress7(String value) {
        this.address7 = value;
    }

    /**
     * Gets the value of the address8 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress8() {
        return address8;
    }

    /**
     * Sets the value of the address8 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress8(String value) {
        this.address8 = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

}