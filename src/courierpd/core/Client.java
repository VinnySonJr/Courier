package courierpd.core;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import courierpd.map.Intersection;

/**
 * Represents a customer of Acme Courier Services. 
 * Clients contact the company to have packages of papers picked-up and delivered to another client. 
 * Therefore, clients often come in pairs.
 */
@Entity(name = "client")
public class Client implements Serializable{

    /**
	 * Allows Serialization so that the item may be stored in the
	 * database
	 */
	private static final long serialVersionUID = 2312995381938814489L;
	/**
     * The name of the client's organization
     */
	@Column(name = "client_name", nullable = false)
    private String name;
    /**
     * The unique identifier of a client organization.
     */
    @Id //signifies the primary key
    @Column(name = "client_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountNumber;
    /**
     * Specifies whether the client is actively using Acme Couriers services. 
     * Clients that are inactive no longer appear on the normal reports, 
     * and they do not receive reports that are generated and distributed 
     * to all clients on a regular basis.
     */
    @Column(name = "client_is_active", nullable = false)
    private boolean isActive = true;
    /**
     * The email provided by the client will receive delivery confirmation notices from Ubiquity. 
     * This is required for the system to work as intended.
     */
    @Column(name = "client_email", nullable = false)
    private String email;
    /**
     * The phone number of the client, which is not used by Ubiquity for processing. 
     * Ubiquity stores this number in case their is an issue with the email system. 
     * This will allow Order Takers to call, as they once did, to verify that a 
     * package has been delivered.
     */
    @Column(name = "client_phone_number", nullable = false)
    private String phoneNumber;
    /**
     * The intersection at which the client's office building is located.
     */
    @OneToOne(optional = false)
    @JoinColumn(name = "client_location_id", nullable = false, referencedColumnName = "intersection_id")
    private Intersection location;

    @OneToMany(targetEntity = DeliveryTicket.class, mappedBy = "pickUpClient")
	protected Collection<DeliveryTicket> pickUpDeliveryTickets;
    
    @OneToMany(targetEntity = DeliveryTicket.class, mappedBy = "deliveryClient")
	protected Collection<DeliveryTicket> deliveryDeliveryTickets;
    
    /**
     * Returns the name of the client's organization.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the client's organization.
     * @param name The name to be used as that of the client's organization.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the client's unique identification number.
     */
    public int getAccountNumber() {
        return this.accountNumber;
    }

    /**
     * Sets the clients unique identification number.
     * @param accountNumber The unique identification number to be used for a client.
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Returns whether the client is active.
     */
    public boolean getIsActive() {
        return this.isActive;
    }

    /**
     * Sets whether the client is active.
     * @param isActive The active state of the client to apply.
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * Return the email of the client organization in the system.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Set the client's email in the system.
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Return the phone number of the client.
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Sets the client's phone number in the system.
     * @param phoneNumber The client's phone number to set in the system.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * The default constructor for a client.
     */
    public Client() {
        //JPA handles making the collections for me, so I don't need to do
    	// that here.
    }

    /**
     * Returns the intersection at which a client's office is located.
     */
    public Intersection getLocation() {
        return this.location;
    }

    /**
     * Set the intersection at which a client's office is located.
     * @param location The intersection at which the client's office is located.
     */
    public void setLocation(Intersection location) {
        this.location = location;
    }
    
    /**
     * Gets the serialization unique identifier
     * @return serialVersionUID
     */
    public static long getSerialversionuid() {
		return serialVersionUID;
	}
   /* @Override
    public String toString(){
    	return this.name;
    }*/

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String finalString = accountNumber + "\t" + name + "\t" + phoneNumber + "\t" + email;
		
		return finalString;
	}

}