package ren.xiayi.cig.queue.catdog;

import java.util.Queue;

import com.google.common.base.Preconditions;

public class CatDogQueue {
    private Queue<CatDogQueueElement> catQueue;//cat类别队列
    private Queue<CatDogQueueElement> dogQueue;//dog类别队列
    private int index;

    public Queue<CatDogQueueElement> getCatQueue() {
        return catQueue;
    }

    public void setCatQueue(Queue<CatDogQueueElement> catQueue) {
        this.catQueue = catQueue;
    }

    public Queue<CatDogQueueElement> getDogQueue() {
        return dogQueue;
    }

    public void setDogQueue(Queue<CatDogQueueElement> dogQueue) {
        this.dogQueue = dogQueue;
    }

    /**
     * isCatEmpty 判断队列cat是否为空
     */
    public boolean isCatEmpty() {
        return catQueue.isEmpty();
    }

    /**
     * isDogEmpty 判断队列dog是否为空
     */
    public boolean isDogEmpty() {
        return dogQueue.isEmpty();
    }

    /**
     * isEmpty 判断队列是否为空
     */
    public boolean isEmpty() {
        return catQueue.isEmpty() && dogQueue.isEmpty();
    }

    /**
     * add方法将cat或dog加入队列中
     */
    public void add(Pet pet) {
        CatDogQueueElement element = new CatDogQueueElement(pet, index++);
        if (pet.getType().equals("dog")) {
            dogQueue.add(element);
        } else if (pet.getType().equals("cat")) {
            catQueue.add(element);
        }
    }

    /**
     * pollDog 将dog类别元素按照进队列先后顺序依次弹出
     */
    public Pet pollDog() {
        Preconditions.checkNotNull(dogQueue);
        if (!dogQueue.isEmpty()) {
            return dogQueue.poll().getPet();
        }
        return null;
    }

    /**
     * pollCat 将cat类别元素按照进队列先后顺序依次弹出
     */
    public Pet pollCat() {
        Preconditions.checkNotNull(catQueue);
        if (!catQueue.isEmpty()) {
            return catQueue.poll().getPet();
        }
        return null;
    }

    /**
     * poll 将队列所有类别元素按照进队列先后顺序依次弹出
     */
    public Pet poll() {
        if (catQueue.isEmpty() && dogQueue.isEmpty()) {
            return null;
        }
        if (catQueue.isEmpty()) {
            return dogQueue.poll().getPet();
        }
        if (dogQueue.isEmpty()) {
            return catQueue.poll().getPet();
        }
        int catElementAge = catQueue.peek().getElementAge();
        int dogElementAge = dogQueue.peek().getElementAge();
        if (catElementAge < dogElementAge) {
            return catQueue.poll().getPet();
        } else if (catElementAge == dogElementAge) {
            throw new RuntimeException("add pet err!");
        } else {
            return dogQueue.poll().getPet();
        }
    }

}
