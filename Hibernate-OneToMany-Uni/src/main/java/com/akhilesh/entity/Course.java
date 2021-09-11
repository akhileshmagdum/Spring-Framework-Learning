package com.akhilesh.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,
            CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    /*
    We have OneToMany relation with reviews with join column course_id.
    But in course table we do not have column course_id?
    -----------------------------------------------------
    The JoinColumn is actually fairly complex, & it goes through a number of advanced steps to find the desired column
    Documentation: https://docs.oracle.com/javaee/7/api/javax/persistence/JoinColumn.html#name

    The table in which it is found depends upon the context:
- If the join is for a OneToOne or ManyToOne mapping using a foreign key mapping strategy,
    the foreign key column is in the table of the source entity or embeddable.

- If the join is for a unidirectional OneToMany mapping using a foreign key mapping strategy,
    the foreign key is in the table of the target entity.

- If the join is for a ManyToMany mapping or for a OneToOne or bidirectional ManyToOne/OneToMany mapping using a join table,
    the foreign key is in a join table.

- If the join is for an element collection, the foreign key is in a collection table.
----------------------------------------------------------
----------------------------------------------------------
----------------------------------------------------------
we are using @OneToMany uni-directional (course has one-to-many reviews).
As a result, the join column / foreign key column is in the target entity.
In this case, the target entity is the Review class.
So, you will find the join column "course_id" in the "review" table.
     */
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Review> reviewList;

    public Course() { }

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    //Convenience method
    public void add(Review review){
        if(reviewList==null){
            reviewList = new ArrayList<>();
        }
        reviewList.add(review);
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                '}';
    }
}
