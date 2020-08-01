package ru.javaops.masterjava.xml.schema;


import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 *     &lt;xs:complexType name="groupType">
 *         &lt;xs:sequence>
 *             &lt;xs:element name="Name" type="xs:string"/>
 *         &lt;/xs:sequence>
 *         &lt;xs:attribute type="gType" name="Type" use="required"/>
 *     &lt;/xs:complexType>
 * </pre>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Group", namespace = "http://javaops.ru")
@XmlType(name = "", propOrder = {
        "name",
        "type"
})
public class Group {
    @XmlElement(namespace = "http://javaops.ru", required = true)
    private String name;
    @XmlElement(namespace = "http://javaops.ru", required = true)
    private GroupType type;
    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of the group's type property.
     *
     * @return
     *     possible object is
     *     {@link GroupType }
     *
     */
    public GroupType getType() {
        return type;
    }

    public void setType(GroupType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
