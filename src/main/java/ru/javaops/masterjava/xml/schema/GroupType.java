package ru.javaops.masterjava.xml.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for flagType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
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
@XmlType(name = "gType", namespace = "http://javaops.ru")
@XmlEnum
public enum GroupType {
    @XmlEnumValue("registering")
    REGISTERING("registering"),
    @XmlEnumValue("current")
    CURRENT("current"),
    @XmlEnumValue("finished")
    FINISHED("finished");

    private final String name;

    GroupType(String name) {
        this.name = name;
    }

    public String value() {
        return name;
    }

    public static GroupType fromValue(String v) {
        for (GroupType groupType: GroupType.values()) {
            if (groupType.name.equals(v)) {
                return groupType;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
