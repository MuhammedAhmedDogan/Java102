package business;

import core.Helper;
import dao.ModelDao;
import entity.Model;

import java.util.ArrayList;

public class ModelManager {
    private final ModelDao modelDao = new ModelDao();

    public Model getById(int id) {
        return this.modelDao.getById(id);
    }

    public ArrayList<Model> findAll() {
        return this.modelDao.findAll();
    }

    public ArrayList<Model> getByListBrandId(int brandId) {
        return modelDao.getByListBrandId(brandId);
    }

    public ArrayList<Object[]> getForTable(int size, ArrayList<Model> models) {
        ArrayList<Object[]> modelList = new ArrayList<>();
        for (Model obj : models) {
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = obj.getId();
            rowObject[i++] = obj.getBrand().getName();
            rowObject[i++] = obj.getName();
            rowObject[i++] = obj.getType();
            rowObject[i++] = obj.getYear();
            rowObject[i++] = obj.getFuel();
            rowObject[i++] = obj.getGear();
            modelList.add(rowObject);
        }
        return modelList;
    }

    public boolean save(Model model) {
        if (this.getById(model.getId()) != null) {
            Helper.showMessage("error");
            return false;
        }
        return this.modelDao.save(model);
    }

    public boolean update(Model model) {
        if (this.getById(model.getId()) == null) {
            Helper.showMessage(model.getId() + " ID Kayıtlı model bulunamadı !");
            return false;
        }
        return this.modelDao.update(model);
    }

    public boolean delete(int id) {
        if (this.getById(id) == null) {
            Helper.showMessage(id + " ID Kayıtlı model bulunamadı !");
            return false;
        }
        return this.modelDao.delete(id);
    }

    public ArrayList<Model> serchForTable(int brandId, Model.Fuel fuel, Model.Type type, Model.Gear gear) {
        String select = "SELECT * FROM public.model";
        ArrayList<String> whereList = new ArrayList<>();

        if (brandId != 0) {
            whereList.add("model_brand_id = " + brandId);
        }

        if (fuel != null) {
            whereList.add("model_fuel = '" + fuel.toString() + "'");
        }

        if (type != null) {
            whereList.add("model_type = '" + type.toString() + "'");
        }

        if (gear != null) {
            whereList.add("model_gear = '" + gear.toString() + "'");
        }

        String whereStr = String.join(" AND ", whereList);
        String query = select;
        if (!whereStr.isEmpty()) {
            query += " WHERE " + whereStr;
        }

        return this.modelDao.selectByQuery(query);
    }

}
