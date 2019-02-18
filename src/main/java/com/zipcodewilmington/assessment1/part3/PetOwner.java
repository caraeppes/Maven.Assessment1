package com.zipcodewilmington.assessment1.part3;

/**
 * Created by leon on 2/16/18.
 */
public class PetOwner {

    private String name;
    private Pet[] pets = new Pet[0];

    /**
     * @param name name of the owner of the Pet
     * @param pets array of Pet object
     */
    public PetOwner(String name, Pet... pets) {
        this.name = name;
        if (pets != null) {
            this.pets = new Pet[pets.length];
        }
        int index = 0;
        if(pets != null) {
            for (Pet p : pets) {
                this.pets[index] = p;
                index++;
            }
        }
        for(Pet p : this.pets) {
            p.setOwner(this);
        }
    }

    /**
     * @param pet pet to be added to the composite collection of Pets
     */
    public void addPet(Pet pet) {
        Pet[] newPets = new Pet[1];
        newPets[0] = pet;
        this.pets = newPets;

    }

    /**
     * @param pet pet to be removed from the composite collection Pets
     */
    public void removePet(Pet pet) {
        int numberOfPets = 0;
        for (Pet p : pets) {
            if (!p.equals(pet)) {
                numberOfPets++;
            }
        }
        if (numberOfPets == 0) {
            this.pets = new Pet[]{null};
        } else {
            Pet[] newPets = new Pet[numberOfPets];
            int index = 0;
            for (Pet p : pets) {
                if (!p.equals(pet)) {
                    newPets[index] = p;
                    index++;
                }
            }
            this.pets = newPets;
        }
    }

    /**
     * @param pet pet to evaluate ownership of
     * @return true if I own this pet
     */
    public Boolean isOwnerOf(Pet pet) {
        for (Pet p : pets) {
            if (p.equals(pet)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return the age of the Pet object whose age field is the lowest amongst all Pets in this class
     */
    public Integer getYoungetPetAge() {
        Integer min = getOldestPetAge();
        for (Pet p : pets){
            if (p.getAge() < min){
                min = p.getAge();
            }
        }
        return min;
    }


    /**
     * @return the age of the Pet object whose age field is the highest amongst all Pets in this class
     */
    public Integer getOldestPetAge() {
        Integer max = 0;
        for (Pet p : pets){
            if (p.getAge() > max){
                max = p.getAge();
            }
        }
        return max;
    }


    /**
     * @return the sum of ages of Pet objects stored in this class divided by the number of Pet object
     */
    public Float getAveragePetAge() {
        int sum = 0;
        for (Pet p : pets){
            sum += p.getAge();
        }
        return (float)(sum / pets.length);
    }

    /**
     * @return the number of Pet objects stored in this class
     */
    public Integer getNumberOfPets() {
        return this.pets.length;
    }

    /**
     * @return the name property of the Pet
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return array representation of animals owned by this PetOwner
     */
    public Pet[] getPets() {
        return this.pets;
    }
}
