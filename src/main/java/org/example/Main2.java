package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main2 {
    private final static CountDownLatch countDownLatch = new CountDownLatch(3);
    private static final int NUMBER_OF_THREAD = 8;
    public static void UncheckableSleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
//        SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Item.class) // Классы подключаем
//                .buildSessionFactory();
        //Пессимистик метод
//        Session session = factory.getCurrentSession();
//        session.beginTransaction();
//        int sumValue =  0;
//        List<Item> items = session.createQuery( "SELECT i FROM Item i" , Item.class ).setLockMode(LockModeType.PESSIMISTIC_READ).getResultList();
//        for  (Item o : items) {    sumValue += o.getValues() ; }
//        session.getTransaction().commit();


//        Session session = factory.getCurrentSession();
//        session.beginTransaction();
//        for (int i = 0; i < 40; i++) {
//            Item2 item = new Item2(0);
//            session.save(item);
//        }
//        session.getTransaction().commit();

//        session.beginTransaction();
//        Item item = session.find(Item.class, 1L);
//        System.out.println(item.getVersion());
//        // <-1
//         item.setValues( 20);
//         session.flush();
//         System.out.println(item.getVersion());
////         <-2
//         item.setValues( 30);
//         session.flush();
//         System.out.println(item.getVersion());
////         <-3
//         session.getTransaction().rollback();
//         session = factory.getCurrentSession();
//         session.beginTransaction();
//         item = session.find(Item. class ,  1L );
//         System.out.println(item.getVersion());
////         <-1
//         session.getTransaction().commit();
//         session.close();
        CountDownLatch countDownLatch = new CountDownLatch(NUMBER_OF_THREAD);
        Thread[] threads = new Thread[NUMBER_OF_THREAD];
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Item.class) // Классы подключаем
                .buildSessionFactory()) {
            for (int i = 0; i < NUMBER_OF_THREAD; i++) {
                final int u = i;
            }
            for (int i = 0; i < 8; i++) {
                threads[i] = new Thread(() -> {
                    for (int j = 0; j < 20000; j++) {
                        System.out.println("Thread  #2  started");
                        Session session = factory.getCurrentSession();
                        session.beginTransaction();
                        Item2 item = session.get(Item2.class, 1L);
//             <-version = 1
                        int itm = item.getVal();
                        int test = itm + 1;
                        item.setVal(test);
                        UncheckableSleep(3000);
                        try {
                            session.save(test);
                            session.getTransaction().commit();
                            System.out.println("Thread #2 committed");
                        } catch (OptimisticLockException e) {
                            session.getTransaction().rollback();
                            System.out.println("Thread  #2  rollback");
                            e.printStackTrace();
                        }
                        if (session != null) {
                            session.close();
                        }
                        countDownLatch.countDown();
                    }

                });
                threads[i].start();
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


//
//        new Thread(() -> {
//            System.out.println("Thread  #1  started");
//            Session session = factory.getCurrentSession();
//            session.beginTransaction();
//            Item2 item = session.get(Item2.class, 1L);
//            // <-version = 1
//            item.setVal(100);
//            try {
//                uncheckableSleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            session.save(item);
//            session.getTransaction().commit();
////            version увеличиваетсядо2
//            System.out.println("Thread #1 committed");
//            if (session != null) {
//                session.close();
//            }
//            countDownLatch.countDown();
//        }).start();
//        new Thread(() -> {
//            System.out.println("Thread  #2  started");
//            Session session = factory.getCurrentSession();
//            session.beginTransaction();
//            Item2 item = session.get(Item2.class, 1L);
////             <-version = 1
//            item.setVal(200);
//            try {
//                uncheckableSleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            try {
//                session.save(item);
//                session.getTransaction().commit();
//                System.out.println("Thread #2 committed");
//            } catch (OptimisticLockException e) {
//                session.getTransaction().rollback();
//                System.out.println("Thread  #2  rollback");
//                e.printStackTrace();
//            }
//            if (session != null) {
//                session.close();
//            }
//            countDownLatch.countDown();
//        }).start();
//        try {
//            countDownLatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        }
//
//    private static void uncheckableSleep(int i) throws InterruptedException {
//        Thread.sleep(i);
//    }
    }
}
