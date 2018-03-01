package mx.kevinmont.earthquake.issue.rest.vo;

/**
 *
 * @author mont
 */
public class TemporaryShelter {

    /**
     * @return the temporaryShelter
     */
    public short getTemporaryShelter() {
        return temporaryShelter;
    }

    /**
     * @param temporaryShelter the temporaryShelter to set
     */
    public void setTemporaryShelter(short temporaryShelter) {
        this.temporaryShelter = temporaryShelter;
    }

    /**
     * @return the addressId
     */
    public short getAddressId() {
        return addressId;
    }

    /**
     * @param addressId the addressId to set
     */
    public void setAddressId(short addressId) {
        this.addressId = addressId;
    }

    /**
     * @return the temporaryName
     */
    public String getTemporaryName() {
        return temporaryName;
    }

    /**
     * @param temporaryName the temporaryName to set
     */
    public void setTemporaryName(String temporaryName) {
        this.temporaryName = temporaryName;
    }
    
    private short temporaryShelter;
    private short addressId;
    private String temporaryName;
}
