
package com.cox.bis.customer.account.addrsscrub.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cox.bis.commons.addressscrub.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CityScrub_QNAME = new QName("http://businessobjects.com/service/SingleAddressTransactional/output", "cityScrub");
    private final static QName _Address5_QNAME = new QName("http://businessobjects.com/service/SingleAddressTransactional/input", "address5");
    private final static QName _Address4_QNAME = new QName("http://businessobjects.com/service/SingleAddressTransactional/input", "address4");
    private final static QName _Address7_QNAME = new QName("http://businessobjects.com/service/SingleAddressTransactional/input", "address7");
    private final static QName _Zip5Scrub_QNAME = new QName("http://businessobjects.com/service/SingleAddressTransactional/output", "zip5Scrub");
    private final static QName _Address6_QNAME = new QName("http://businessobjects.com/service/SingleAddressTransactional/input", "address6");
    private final static QName _Address8_QNAME = new QName("http://businessobjects.com/service/SingleAddressTransactional/input", "address8");
    private final static QName _Zip4Scrub_QNAME = new QName("http://businessobjects.com/service/SingleAddressTransactional/output", "zip4Scrub");
    private final static QName _UnitTypeScrub_QNAME = new QName("http://businessobjects.com/service/SingleAddressTransactional/output", "unitTypeScrub");
    private final static QName _PostDirScrub_QNAME = new QName("http://businessobjects.com/service/SingleAddressTransactional/output", "postDirScrub");
    private final static QName _FaultCodeScrub_QNAME = new QName("http://businessobjects.com/service/SingleAddressTransactional/output", "faultCodeScrub");
    private final static QName _PreDirScrub_QNAME = new QName("http://businessobjects.com/service/SingleAddressTransactional/output", "preDirScrub");
    private final static QName _StreetNameScrub_QNAME = new QName("http://businessobjects.com/service/SingleAddressTransactional/output", "streetNameScrub");
    private final static QName _UnitScrub_QNAME = new QName("http://businessobjects.com/service/SingleAddressTransactional/output", "unitScrub");
    private final static QName _StreetNumberScrub_QNAME = new QName("http://businessobjects.com/service/SingleAddressTransactional/output", "streetNumberScrub");
    private final static QName _StateScrub_QNAME = new QName("http://businessobjects.com/service/SingleAddressTransactional/output", "stateScrub");
    private final static QName _Country_QNAME = new QName("http://businessobjects.com/service/SingleAddressTransactional/input", "country");
    private final static QName _Address1_QNAME = new QName("http://businessobjects.com/service/SingleAddressTransactional/input", "address1");
    private final static QName _StreetTypeScrub_QNAME = new QName("http://businessobjects.com/service/SingleAddressTransactional/output", "streetTypeScrub");
    private final static QName _Address3_QNAME = new QName("http://businessobjects.com/service/SingleAddressTransactional/input", "address3");
    private final static QName _Address2_QNAME = new QName("http://businessobjects.com/service/SingleAddressTransactional/input", "address2");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for
     * 
     */
    public ObjectFactory() {
    }

      /**
     * Create an instance of {@link SingleAddressTransactionalIn }
     * 
     */
    public SingleAddressTransactionalIn createSingleAddressTransactionalIn() {
        return new SingleAddressTransactionalIn();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://businessobjects.com/service/SingleAddressTransactional/output", name = "cityScrub")
    public JAXBElement<String> createCityScrub(String value) {
        return new JAXBElement<String>(_CityScrub_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://businessobjects.com/service/SingleAddressTransactional/input", name = "address5")
    public JAXBElement<String> createAddress5(String value) {
        return new JAXBElement<String>(_Address5_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://businessobjects.com/service/SingleAddressTransactional/input", name = "address4")
    public JAXBElement<String> createAddress4(String value) {
        return new JAXBElement<String>(_Address4_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://businessobjects.com/service/SingleAddressTransactional/input", name = "address7")
    public JAXBElement<String> createAddress7(String value) {
        return new JAXBElement<String>(_Address7_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://businessobjects.com/service/SingleAddressTransactional/output", name = "zip5Scrub")
    public JAXBElement<String> createZip5Scrub(String value) {
        return new JAXBElement<String>(_Zip5Scrub_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://businessobjects.com/service/SingleAddressTransactional/input", name = "address6")
    public JAXBElement<String> createAddress6(String value) {
        return new JAXBElement<String>(_Address6_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://businessobjects.com/service/SingleAddressTransactional/input", name = "address8")
    public JAXBElement<String> createAddress8(String value) {
        return new JAXBElement<String>(_Address8_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://businessobjects.com/service/SingleAddressTransactional/output", name = "zip4Scrub")
    public JAXBElement<String> createZip4Scrub(String value) {
        return new JAXBElement<String>(_Zip4Scrub_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://businessobjects.com/service/SingleAddressTransactional/output", name = "unitTypeScrub")
    public JAXBElement<String> createUnitTypeScrub(String value) {
        return new JAXBElement<String>(_UnitTypeScrub_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://businessobjects.com/service/SingleAddressTransactional/output", name = "postDirScrub")
    public JAXBElement<String> createPostDirScrub(String value) {
        return new JAXBElement<String>(_PostDirScrub_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://businessobjects.com/service/SingleAddressTransactional/output", name = "faultCodeScrub")
    public JAXBElement<String> createFaultCodeScrub(String value) {
        return new JAXBElement<String>(_FaultCodeScrub_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://businessobjects.com/service/SingleAddressTransactional/output", name = "preDirScrub")
    public JAXBElement<String> createPreDirScrub(String value) {
        return new JAXBElement<String>(_PreDirScrub_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://businessobjects.com/service/SingleAddressTransactional/output", name = "streetNameScrub")
    public JAXBElement<String> createStreetNameScrub(String value) {
        return new JAXBElement<String>(_StreetNameScrub_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://businessobjects.com/service/SingleAddressTransactional/output", name = "unitScrub")
    public JAXBElement<String> createUnitScrub(String value) {
        return new JAXBElement<String>(_UnitScrub_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://businessobjects.com/service/SingleAddressTransactional/output", name = "streetNumberScrub")
    public JAXBElement<String> createStreetNumberScrub(String value) {
        return new JAXBElement<String>(_StreetNumberScrub_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://businessobjects.com/service/SingleAddressTransactional/output", name = "stateScrub")
    public JAXBElement<String> createStateScrub(String value) {
        return new JAXBElement<String>(_StateScrub_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://businessobjects.com/service/SingleAddressTransactional/input", name = "country")
    public JAXBElement<String> createCountry(String value) {
        return new JAXBElement<String>(_Country_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://businessobjects.com/service/SingleAddressTransactional/input", name = "address1")
    public JAXBElement<String> createAddress1(String value) {
        return new JAXBElement<String>(_Address1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://businessobjects.com/service/SingleAddressTransactional/output", name = "streetTypeScrub")
    public JAXBElement<String> createStreetTypeScrub(String value) {
        return new JAXBElement<String>(_StreetTypeScrub_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://businessobjects.com/service/SingleAddressTransactional/input", name = "address3")
    public JAXBElement<String> createAddress3(String value) {
        return new JAXBElement<String>(_Address3_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://businessobjects.com/service/SingleAddressTransactional/input", name = "address2")
    public JAXBElement<String> createAddress2(String value) {
        return new JAXBElement<String>(_Address2_QNAME, String.class, null, value);
    }
}