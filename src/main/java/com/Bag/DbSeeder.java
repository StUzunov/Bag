package com.Bag;

import com.Bag.engine.challenge.DailyWaterGenerator;
import com.Bag.models.BagUserRoles;
import com.Bag.models.BagUser;
import com.Bag.models.BagUserRepository;
import com.Bag.models.CustomRole;
import com.Bag.models.challenge.Challenge;
import com.Bag.models.challenge.ChallengeMenu;
import com.Bag.models.water.DayWater;
import com.Bag.models.water.Water;
import com.Bag.models.workout.ExerciseEnum;
import com.Bag.models.food.ServingEnum;
import com.Bag.models.food.Food;
import com.Bag.models.food.Meal;
import com.Bag.models.food.Serving;
import com.Bag.models.workout.Exercise;
import com.Bag.models.workout.Trainings;
import com.Bag.models.workout.Workout;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class DbSeeder implements CommandLineRunner {

    private BagUserRepository bagUserRepository;

    public DbSeeder(BagUserRepository bagUserRepository) {
        this.bagUserRepository = bagUserRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
//        BagUser ivan = new BagUser();
//        ivan.setUsername("onq");
//        //pass BCrypt Hashed
//        ivan.setPassword("123");
//        ivan.setfName("ivan");
//        ivan.setlName("Ivanov");
//        ivan.setRole(BagUserRoles.ADMIN);
//
//        Map<String, Workout> workoutMap = new TreeMap<>();
//        workoutMap.put(new SimpleDateFormat("dd-MM-yyyy").format(new Date()),
//                new Workout(Arrays.asList(
//                        new Exercise(ExerciseEnum.SWIMING, 10),
//                        new Exercise(ExerciseEnum.PULL_UP, 10),
//                        new Exercise(ExerciseEnum.SWIMING, 12))));
//
//        ivan.setTrainings(new Trainings(workoutMap));
//
//        Map<String, Meal> mealMap = new TreeMap<>();
//        mealMap.put(new SimpleDateFormat("dd-MM-yyyy").format(new Date()), new Meal(Arrays.asList(
//                new Serving(ServingEnum.CHICKEN_BREAST, 150),
//                new Serving(ServingEnum.RICE, 100)
//                )));
//        ivan.setFood(new Food(mealMap));
//        ivan.setChallengeMenu(new ChallengeMenu());
//        ivan.getChallengeMenu().addChallenge(new SimpleDateFormat("dd-MM-yyyy").format(new Date()), new Challenge(ExerciseEnum.PULL_UP, 146));
//        ivan.getChallengeMenu().addChallenge("16-05-2014", new Challenge(ExerciseEnum.SWIMING, 60));
//
//        ivan.setDailyGeneratedTrainings(new Trainings(new TreeMap<>()));
//        ivan.getDailyGeneratedTrainings().getWorkouts()
//                .put(new SimpleDateFormat("dd-MM-yyyy").format(new Date()),
//                        new Workout(Arrays.asList(
//                                new Exercise(ExerciseEnum.PULL_UP, 146),
//                                new Exercise(ExerciseEnum.SWIMING, 60))));
//
//        ivan.setFriendsIds(new ArrayList<>());
//        ivan.setWater(new Water(new TreeMap<>()));
//        ivan.getWater().getDayWaterMap().put(new SimpleDateFormat("dd-MM-yyyy").format(new Date()), new DayWater((Integer) new DailyWaterGenerator().generate(100)));
//
//        Collection<CustomRole> roles = new ArrayList<CustomRole>();
//        CustomRole customRole = new CustomRole();
//        customRole.setAuthority("ROLE_USER");
//        roles.add(customRole);
//        ivan.setAuthorities(roles);
//
//        //this.bagUserRepository.deleteAll();
//
//        List<BagUser> users = Arrays.asList(ivan);
//
//
//        this.bagUserRepository.save(users);

    }
}
