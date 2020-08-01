
package ru.javaops.masterjava.xml.schema;

import java.util.ArrayList;
import java.util.List;
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
 *       &lt;all>
 *         &lt;element name="Cities">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded">
 *                   &lt;element ref="{http://javaops.ru}City"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Users">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *                   &lt;element ref="{http://javaops.ru}User"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "cities",
        "users",
        "projects",
        "groups"
})
@XmlRootElement(name = "Payload", namespace = "http://javaops.ru")
public class Payload {

    @XmlElement(name = "Cities", namespace = "http://javaops.ru", required = true)
    protected Payload.Cities cities;
    @XmlElement(name = "Users", namespace = "http://javaops.ru", required = true)
    protected Payload.Users users;
    @XmlElement(name = "Projects", namespace = "http://javaops.ru", required = true)
    protected Payload.Projects projects;
    @XmlElement(name = "Groups", namespace = "http://javaops.ru", required = true)
    protected Payload.Groups groups;
    /**
     * Gets the value of the cities property.
     *
     * @return
     *     possible object is
     *     {@link Payload.Cities }
     *
     */
    public Payload.Cities getCities() {
        return cities;
    }

    /**
     * Sets the value of the cities property.
     *
     * @param value
     *     allowed object is
     *     {@link Payload.Cities }
     *
     */
    public void setCities(Payload.Cities value) {
        this.cities = value;
    }

    /**
     * Gets the value of the users property.
     *
     * @return
     *     possible object is
     *     {@link Payload.Users }
     *
     */
    public Payload.Users getUsers() {
        return users;
    }

    /**
     * Sets the value of the users property.
     *
     * @param value
     *     allowed object is
     *     {@link Payload.Users }
     *
     */
    public void setUsers(Payload.Users value) {
        this.users = value;
    }

    /**
     * Gets the value of the projects property.
     *
     * @return
     *     possible object is
     *     {@link Payload.Projects }
     *
     */
    public Payload.Projects getProjects() {
        return projects;
    }

    /**
     * Sets the value of the projects property.
     *
     * @param value
     *     allowed object is
     *     {@link Payload.Projects }
     *
     */
    public void setProjects(Payload.Projects value) {
        this.projects = value;
    }


    /**
     * Gets the value of the groups property.
     *
     * @return
     *     possible object is
     *     {@link Payload.Groups }
     *
     */
    public Groups getGroups() {
        return groups;
    }

    /**
     * Sets the value of the groups property.
     *
     * @param value
     *     allowed object is
     *     {@link Payload.Groups }
     *
     */
    public void setGroups(Groups value) {
        this.groups = value;
    }

    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence maxOccurs="unbounded">
     *         &lt;element ref="{http://javaops.ru}City"/>
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
            "cityTypes"
    })
    public static class Cities {

        @XmlElement(name = "City", namespace = "http://javaops.ru", required = true)
        protected List<CityType> cityTypes;

        /**
         * Gets the value of the city property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the city property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCity().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CityType }
         *
         *
         */
        public List<CityType> getCityTypes() {
            if (cityTypes == null) {
                cityTypes = new ArrayList<CityType>();
            }
            return this.cityTypes;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
     *         &lt;element ref="{http://javaops.ru}User"/>
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
            "userList"
    })
    public static class Users {

        @XmlElement(name = "User", namespace = "http://javaops.ru")
        protected List<User> userList;

        /**
         * Gets the value of the user property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the user property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUser().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link User }
         *
         *
         */
        public List<User> getUserList() {
            if (userList == null) {
                userList = new ArrayList<User>();
            }
            return this.userList;
        }

    }

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
            "projectList"
    })
    public static class Projects {
        @XmlElement(name = "Project", namespace = "http://javaops.ru")
        protected List<Project> projectList;

        /**
         * Gets the value of the projects property.
         *
         * @return
         *     possible object is
         *     {@link Payload.Projects }
         *
         */
        public List<Project> getProjectList() {
            return projectList;
        }

        /**
         * Sets the value of the projects property.
         *
         * @param value
         *     allowed object is
         *     {@link Payload.Projects }
         *
         */
        public void setProjectList(List<Project> projectList) {
            this.projectList = projectList;
        }
    }

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
    @XmlType(name = "", propOrder = {
            "groupList"
    })
    public static class Groups {
        @XmlElement(name = "Group", namespace = "http://javaops.ru")
        protected List<Group> groupList;

        /**
         * Gets the value of the groups property.
         *
         * @return
         *     possible object is
         *     {@link Payload.Groups }
         *
         */
        public List<Group> getGroupList() {
            return groupList;
        }

        /**
         * Sets the value of the groups property.
         *
         * @param value
         *     allowed object is
         *     {@link Payload.Groups }
         *
         */
        public void setGroupList(List<Group> groupList) {
            this.groupList = groupList;
        }
    }

    @Override
    public String toString() {
        return "Payload{" +
                "cities=" + cities +
                ", users=" + users +
                ", projects=" + projects +
                '}';
    }
}
