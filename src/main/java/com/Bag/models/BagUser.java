package com.Bag.models;

import com.Bag.models.challenge.ChallengeMenu;
import com.Bag.models.food.Food;
import com.Bag.models.water.Water;
import com.Bag.models.workout.Trainings;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Document(collection = "BagUsers")
public class BagUser implements UserDetails {

    @Id
    private String id;

    Collection<? extends GrantedAuthority> list = null;
    private String username;
    private String password;

    private String fName;
    private String lName;
    private String email;
    private double height;
    private double weight;
    private GenderEnum gender;
    private int age;

    //use training services
    private Trainings trainings;
    private Trainings dailyGeneratedTrainings;
    //use food services
    private BigDecimal calories;
    private Food food;
    //use challenge services
    private ChallengeMenu challengeMenu;
    //use friends services
    private List<String> friendsIds;
    //use water services
    private Water water;

    public BagUser() {
        list = new ArrayList<GrantedAuthority>();
    }

    public BagUser(
            String username, String password,
            String fName, String lName, String email, Trainings trainings, Food food, List<String> friendsIds, Water water) {
        this.username = username;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.trainings = trainings;
        this.food = food;
        this.friendsIds = friendsIds;
        this.water = water;
        list = new ArrayList<GrantedAuthority>();
    }

    public BagUser(BagUser bagUser) {
        this.list = bagUser.getAuthorities();
        this.username = bagUser.getUsername();
        this.password = bagUser.getPassword();
        this.fName = bagUser.getfName();
        this.lName = bagUser.getlName();
        this.email = bagUser.getEmail();
        this.height = bagUser.getHeight();
        this.weight = bagUser.getWeight();
        this.gender = bagUser.getGender();
        this.age = bagUser.getAge();
        this.trainings = bagUser.getTrainings();
        this.dailyGeneratedTrainings = bagUser.getDailyGeneratedTrainings();
        this.calories = bagUser.getCalories();
        this.food = bagUser.getFood();
        this.challengeMenu = bagUser.getChallengeMenu();
        this.friendsIds = bagUser.getFriendsIds();
        this.water = bagUser.getWater();
    }

    public BagUserShort getShortInfo(){
        return new BagUserShort(fName, lName);
    }

    public void addFriend(String friendId){
        friendsIds.add(friendId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Trainings getTrainings() {
        return trainings;
    }

    public void setTrainings(Trainings trainings) {
        this.trainings = trainings;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public ChallengeMenu getChallengeMenu() {
        return challengeMenu;
    }

    public void setChallengeMenu(ChallengeMenu challengeMenu) {
        this.challengeMenu = challengeMenu;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getCalories() {
        return calories;
    }

    public void setCalories(BigDecimal calories) {
        this.calories = calories;
    }

    public Trainings getDailyGeneratedTrainings() {
        return dailyGeneratedTrainings;
    }

    public void setDailyGeneratedTrainings(Trainings dailyGeneratedTrainings) {
        this.dailyGeneratedTrainings = dailyGeneratedTrainings;
    }

    public List<String> getFriendsIds() {
        return friendsIds;
    }

    public void setFriendsIds(List<String> friendsIds) {
        this.friendsIds = friendsIds;
    }

    public Water getWater() {
        return water;
    }

    public void setWater(Water water) {
        this.water = water;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.list;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> roles) {
        this.list = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
