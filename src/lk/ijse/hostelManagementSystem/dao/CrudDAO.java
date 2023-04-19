package lk.ijse.hostelManagementSystem.dao;

public interface CrudDAO<Entity,ID>extends SuperDAO {
    ID save(Entity entity);

    void update(Entity entity);

    Entity get(ID id);

    void delete(Entity entity);
}
