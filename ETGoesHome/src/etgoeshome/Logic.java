package etgoeshome;

import java.util.Observable;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class Logic extends Observable {

   protected DBConnector db;
   protected DefaultTableModel tableData;
   protected boolean success = false;

   public void notifyGUI(Object obj) {
      setChanged();
      notifyObservers(obj);
   }

   public Logic() {
      db = new DBConnector();
   }

   public boolean login(String user, String pw) {
      return db.loginToDB(user, pw);
   }

   /* Handle the various State queries */
   public void stateSelect(String state, int queryIndex) {
      switch (queryIndex)
      {
         case 0:
            tableData = db.selectTab1(state);
            break;
         case 1:
            tableData = db.shootingsPerCity(state);
            break;
         case 2:
            tableData = db.sightingsPerCity(state);
            break;
         case 3:
            tableData = db.shootingsSightingsPerCity(state);
            break;
         case 4:
            tableData = db.sightings_MenAndWomenShootingsPerState();
            break;
         case 5:
            tableData = db.sightings_HealthyShootersPerCity(state);
            break;
         default:
            System.err.println("Unrecognized State Query\n");
      }

      notifyGUI(ENotify.AN_STATES);
   }

   /* Handle the various UFO Sighting queries */
   public void sightingSelect(int queryIndex) {
      switch (queryIndex)
      {
         case 0:
            tableData = db.sightingsByShape();
            break;
         case 1:
            tableData = db.sightingsByYear();
            break;
         case 2:
            tableData = db.sightingsByState();
            break;
         case 3:
            tableData = db.longestSighting();
            break;
         case 4:
            tableData = db.mostSightingsByYear();
            break;
         case 5:
            tableData = db.mostSightingsByCity();
            break;
         case 6:
            tableData = db.sawBrightLight();
            break;
         default:
            System.err.println("Unrecognized Sighting Query\n");
      }

      notifyGUI(ENotify.AN_SIGHTINGS);
   }

   /* Handle the various Police Shooting queries */
   public void shootingSelect(int queryIndex) {
      switch (queryIndex)
      {
         case 0:
            tableData = db.shootingsByRace();
            break;
         case 1:
            tableData = db.shootingsByGender();
            break;
         case 2:
            tableData = db.shootingsByDay();
            break;
         case 3:
            tableData = db.shootingsByWeapon();
            break;
         case 4:
            tableData = db.shootingsByCamera();
            break;
         default:
            System.err.println("Unrecognized Shooting Query\n");
      }

      notifyGUI(ENotify.AN_SHOOTINGS);
   }

   public void searchShootingVictim(String victim) {
      tableData = db.searchVictim(victim);
      notifyGUI(ENotify.AN_SHOOTINGS);
   }

   public void addShooting(String name, String date, String death, String weapon,
           int age, String gender, String race, String city, String state, String mental,
           String threat, String flee, String camera) {

      success = db.addShooting(name, date, death, weapon, age, gender, race, city, state, mental, threat, flee, camera);
      notifyGUI(ENotify.ADD_SHOOTING);
   }

   public void addUfo(String occur, String city, String state, String shape,
           int duration, String descript) {

      success = db.addSighting(occur, city, state, shape, duration, descript);
      notifyGUI(ENotify.ADD_SIGHTING);
   }
}
