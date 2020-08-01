package ru.javaops.masterjava.xml.schema;


import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 *     &lt;xs:complexType name="projectType">
 *         &lt;xs:sequence>
 *             &lt;xs:element name="Name" type="xs:string"/>
 *             &lt;xs:element name="Description" type="xs:string"/>
 *             &lt;xs:element name="Group" type="groupType"/>
 *         &lt;/xs:sequence>
 *     &lt;/xs:complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "name",
        "description",
        "group"
})
@XmlRootElement(name = "User", namespace = "http://javaops.ru")
public class Project {
    @XmlElement(namespace = "http://javaops.ru", required = true)
    private String name;
    @XmlElement(namespace = "http://javaops.ru", required = true)
    private String description;
    @XmlElement(namespace = "http://javaops.ru", required = true)
    private Group group;

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
     * Gets the value of the description property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Gets the value of the group property.
     *
     * @return
     *     possible object is
     *     {@link Group }
     *
     */
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", group=" + group +
                '}';
    }
}
