package ovh.challangers.tokentolearn;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.UpdateOperations;
import ovh.challangers.tokentolearn.beans.*;
import ovh.challangers.tokentolearn.controlers.database.DaoFactory;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

public class CreateData {
    public static void main(String[]args) {
        Datastore datastore = DaoFactory.getDatastore();

//        datastore.delete(datastore.createQuery(User.class));
//        datastore.delete(datastore.createQuery(Group.class));
//        datastore.delete(datastore.createQuery(Project.class));
//        datastore.delete(datastore.createQuery(Student.class));
//
//        System.out.println(datastore.find(User.class).asList());
//        System.out.println(datastore.find(Group.class).asList());
//        System.out.println(datastore.find(Project.class).asList());
//        System.out.println(datastore.find(Student.class).asList());
//
//        User eleve = new User();
//        eleve.setId("benoit.jaouen@epsi.fr");
//        eleve.setPassword("403bb5c89a7e3f69db1655719f0c898453006306c009af538604542c790ef083");
//        eleve.setType(UserType.STUDENT);
//        Key<User> t1 = datastore.save(eleve);
//        System.out.println(datastore.find(User.class).asList());
////
//        Student leStudent = new Student();
//        leStudent.setUser(eleve);
//        leStudent.setProjects(new ArrayList<>());
//        Key<Student> t2 = datastore.save(leStudent);
//        System.out.println(datastore.find(Group.class).asList());
//
//        User sylvain = new User();
//        sylvain.setType(UserType.TUTOR);
//        sylvain.setId("sylvain.chall@epsi.fr");
//        sylvain.setPassword("403bb5c89a7e3f69db1655719f0c898453006306c009af538604542c790ef083");
//        Key<User> t3 = datastore.save(sylvain);
//
//        Tutor tutor = new Tutor();
//        tutor.setUser(sylvain);
//        Key<Tutor> t4 = datastore.save(tutor);
//
//        Group g = new Group();
//        g.setGroupid("Tokette");
//        g.setToken(40);
//        g.setGroupStudent(new ArrayList<>());
//        g.getGroupStudent().add(eleve);
//        Key<Group> t5 = datastore.save(g);
//
//        Project p = new Project();
//        p.setId("Challangers");
//        p.setInitialToken(40);
//        p.setGroups(new ArrayList<>());
//        p.getGroups().add(g);
//        p.setTutors(new ArrayList<>());
//        p.getTutors().add(sylvain);
//        Key<Project> t6 = datastore.save(p);

//        Project p = datastore.createQuery(Project.class).field("id").equal("Challangers").get();
//        User us = datastore.createQuery(User.class).field("id").equal("benoit.jaouen@epsi.fr").get();
//        Student benoit = datastore.createQuery(Student.class).field("user").equal(us).get();
//        benoit.setProjects(new ArrayList<>());
//        benoit.getProjects().add(p);
//        datastore.delete(datastore.createQuery(Tutor.class));

//        User sylvain = new User();
//        sylvain.setType(UserType.TUTOR);
//        sylvain.setId("sylvain.chall@epsi.fr");
//        sylvain.setPassword("403bb5c89a7e3f69db1655719f0c898453006306c009af538604542c790ef083");
//        Key<User> t3 = datastore.save(sylvain);
        User user = datastore.createQuery(User.class).field("id").equal("benoit.jaouen@epsi.fr").get();
        Group g = new Group();
        g.setGroupid("Tokenizer");
        g.setToken(40);
        g.setGroupStudent(new ArrayList<>());
        g.getGroupStudent().add(user);
        Key<Group> t5 = datastore.save(g);

//        Tutor tutor = new Tutor();
//        tutor.setUser(user);
//        List<Tutor.WaitingQueue> file = new ArrayList<>();
//        Group g = datastore.createQuery(Group.class).field("groupId").equal("Tokette").get();
//        Project p = datastore.createQuery(Project.class).field("id").equal("Challangers").get();
//        Intervention t = new Intervention();
//        t.group = g;
//        t.canal = Canal.OTHER;
//        Key<Intervention> t5 = datastore.save(t);
//
//        Tutor.WaitingQueue queue = new Tutor.WaitingQueue();
//        queue.value = t;
//        queue.key = p;
//
//        file.add(queue);
//        tutor.setWaitingqueue(file);
//        Key<Tutor> t4 = datastore.save(tutor);



//        UpdateOperations<Student> updateStudent = DaoFactory.getDatastore().createUpdateOperations(Student.class)
//                .addToSet("projects", p);
//        datastore.update(benoit, updateStudent);

        System.out.println(datastore.find(User.class).asList());
        System.out.println(datastore.find(Group.class).asList());
        System.out.println(datastore.find(Project.class).asList());
        System.out.println(datastore.find(Student.class).asList());

    }
}
