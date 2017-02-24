
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
 *         &lt;element ref="{http://businessobjects.com/service/SingleAddressTransactional/output}streetNumberScrub"/>
 *         &lt;element ref="{http://businessobjects.com/service/SingleAddressTransactional/output}preDirScrub"/>
 *         &lt;element ref="{http://businessobjects.com/service/SingleAddressTransactional/output}streetNameScrub"/>
 *         &lt;element ref="{http://businessobjects.com/service/SingleAddressTransactional/output}streetTypeScrub"/>
 *         &lt;element ref="{http://businessobjects.com/service/SingleAddressTransactional/output}postDirScrub"/>
 *         &lt;element ref="{http://businessobjects.com/service/SingleAddressTransactional/output}unitScrub"/>
 *         &lt;element ref="{http://businessobjects.com/service/SingleAddressTransactional/output}cityScrub"/>
 *         &lt;element ref="{http://businessobjects.com/service/SingleAddressTransactional/output}stateScrub"/>
 *         &lt;element ref="{http://businessobjects.com/service/SingleAddressTransactional/output}zip5Scrub"/>
 *         &lt;element ref="{http://businessobjects.com/service/SingleAddressTransactional/output}zip4Scrub"/>
 *         &lt;element ref="{http://businessobjects.com/service/SingleAddressTransactional/output}faultCodeScrub"/>
 *         &lt;element ref="{http://businessobjects.com/service/SingleAddressTransactional/output}unitTypeScrub"/>
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
    "streetNumberScrub",
    "preDirScrub",
    "streetNameScrub",
    "streetTypeScrub",
    "postDirScrub",
    "unitScrub",
    "cityScrub",
    "stateScrub",
    "zip5Scrub",
    "zip4Scrub",
    "faultCodeScrub",
    "unitTypeScrub"
})
@XmlRootElement(name = "SingleAddressTransactionalOut", namespace = "http://businessobjects.com/service/SingleAddressTransactional/output")
public class SingleAddressTransactionalOut {

    @XmlElement(namespace = "http://businessobjects.com/service/SingleAddressTransactional/output", required = true)
    protected String streetNumberScrub;
    @XmlElement(namespace = "http://businessobjects.com/service/SingleAddressTransactional/output", required = true)
    protected String preDirScrub;
    @XmlElement(namespace = "http://businessobjects.com/service/SingleAddressTransactional/output", required = true)
    protected String streetNameScrub;
    @XmlElement(namespace = "http://businessobjects.com/service/SingleAddressTransactional/output", required = true)
    protected String streetTypeScrub;
    @XmlElement(namespace = "http://businessobjects.com/service/SingleAddressTransactional/output", required = true)
    protected String postDirScrub;
    @XmlElement(namespace = "http://businessobjects.com/service/SingleAddressTransactional/output", required = true)
    protected String unitScrub;
    @XmlElement(namespace = "http://businessobjects.com/service/SingleAddressTransactional/output", required = true)
    protected String cityScrub;
    @XmlElement(namespace = "http://businessobjects.com/service/SingleAddressTransactional/output", required = true)
    protected String stateScrub;
    @XmlElement(namespace = "http://businessobjects.com/service/SingleAddressTransactional/output", required = true)
    protected String zip5Scrub;
    @XmlElement(namespace = "http://businessobjects.com/service/SingleAddressTransactional/output", required = true)
    protected String zip4Scrub;
    @XmlElement(namespace = "http://businessobjects.com/service/SingleAddressTransactional/output", required = true)
    protected String faultCodeScrub;
    @XmlElement(namespace = "http://businessobjects.com/service/SingleAddressTransactional/output", required = true)
    protected String unitTypeScrub;

    /**
     * Gets the value of the streetNumberScrub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetNumberScrub() {
        return streetNumberScrub;
    }

    /**
     * Sets the value of the streetNumberScrub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetNumberScrub(String value) {
        this.streetNumberScrub = value;
    }

    /**
     * Gets the value of the preDirScrub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreDirScrub() {
        return preDirScrub;
    }

    /**
     * Sets the value of the preDirScrub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreDirScrub(String value) {
        this.preDirScrub = value;
    }

    /**
     * Gets the value of the streetNameScrub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetNameScrub() {
        return streetNameScrub;
    }

    /**
     * Sets the value of the streetNameScrub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetNameScrub(String value) {
        this.streetNameScrub = value;
    }

    /**
     * Gets the value of the streetTypeScrub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetTypeScrub() {
        return streetTypeScrub;
    }

    /**
     * Sets the value of the streetTypeScrub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetTypeScrub(String value) {
        this.streetTypeScrub = value;
    }

    /**
     * Gets the value of the postDirScrub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostDirScrub() {
        return postDirScrub;
    }

    /**
     * Sets the value of the postDirScrub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostDirScrub(String value) {
        this.postDirScrub = value;
    }

    /**
     * Gets the value of the unitScrub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitScrub() {
        return unitScrub;
    }

    /**
     * Sets the value of the unitScrub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitScrub(String value) {
        this.unitScrub = value;
    }

    /**
     * Gets the value of the cityScrub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityScrub() {
        return cityScrub;
    }

    /**
     * Sets the value of the cityScrub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityScrub(String value) {
        this.cityScrub = value;
    }

    /**
     * Gets the value of the stateScrub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateScrub() {
        return stateScrub;
    }

    /**
     * Sets the value of the stateScrub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateScrub(String value) {
        this.stateScrub = value;
    }

    /**
     * Gets the value of the zip5Scrub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZip5Scrub() {
        return zip5Scrub;
    }

    /**
     * Sets the value of the zip5Scrub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZip5Scrub(String value) {
        this.zip5Scrub = value;
    }

    /**
     * Gets the value of the zip4Scrub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZip4Scrub() {
        return zip4Scrub;
    }

    /**
     * Sets the value of the zip4Scrub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZip4Scrub(String value) {
        this.zip4Scrub = value;
    }

    /**
     * Gets the value of the faultCodeScrub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaultCodeScrub() {
        return faultCodeScrub;
    }

    /**
     * Sets the value of the faultCodeScrub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaultCodeScrub(String value) {
        this.faultCodeScrub = value;
    }

    /**
     * Gets the value of the unitTypeScrub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitTypeScrub() {
        return unitTypeScrub;
    }

    /**
     * Sets the value of the unitTypeScrub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitTypeScrub(String value) {
        this.unitTypeScrub = value;
    }

}