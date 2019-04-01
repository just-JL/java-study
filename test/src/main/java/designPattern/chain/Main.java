package designpattern.chain;

/**
 * @author:jiliang
 * @Date:2019/3/17
 * @Time:20:30
 */
public class Main {

    public static void main(String[] args) {
        Support alice = new NoSupport("Alice");
        Support bob = new OddSupport("Bob");
        Support fred = new OddSupport("Fred");

        alice.setNext(bob).setNext(fred);

        for (int i=0; i<10; i++){
            alice.support(new Trouble(i));
        }
    }
}
