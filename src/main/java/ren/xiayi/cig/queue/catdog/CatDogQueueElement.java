package ren.xiayi.cig.queue.catdog;

public class CatDogQueueElement {

    private Pet pet;
    private int elementAge;

    public CatDogQueueElement(Pet pet, int elementAge) {
        super();
        this.pet = pet;
        this.elementAge = elementAge;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public int getElementAge() {
        return elementAge;
    }

    public void setElementAge(int elementAge) {
        this.elementAge = elementAge;
    }
}
