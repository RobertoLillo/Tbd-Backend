package cl.tbd.back.dao.das;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import cl.tbd.back.dao.Volunteer_AbilityDao;
import cl.tbd.back.model.Volunteer_Ability;

@Repository("postgresVolunteer_Ability")
public class Volunteer_AbilityDataAccessService implements Volunteer_AbilityDao {

    @Autowired
    private Sql2o sql2o;

    @Override
    public int insertVolunteer_Ability(UUID id, Volunteer_Ability volunteer_ability) {
        final String sql = "INSERT INTO volunteers_abilities (id, id_volunteer, id_ability) VALUES (:id, :id_volunteer, :id_ability)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("id", id)
                .addParameter("id_volunteer", volunteer_ability.getId_volunteer())
                .addParameter("id_ability", volunteer_ability.getId_ability())
                .executeUpdate();
            return 0;
        }
    }

    @Override
    public List<Volunteer_Ability> selectAllVolunteers_Abilities() {
        final String sql = "SELECT id, id_volunteer, id_ability FROM volunteers_abilities";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                .executeAndFetch(Volunteer_Ability.class);
        }
    }

    @Override
    public int deleteVolunteer_AbilityById(UUID id) {
        return 0;
    }

}