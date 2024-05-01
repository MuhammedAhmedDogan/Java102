package view;

import business.BrandManager;
import core.Helper;
import entity.Brand;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrandView extends Layout {
    private JPanel container;
    private JLabel lbl_brand_name;
    private JTextField fld_brand_name;
    private JButton btn_brand_save;
    private JLabel lbl_brand;
    private Brand brand;
    private BrandManager brandManager;

    public BrandView(Brand brand) {
        this.add(container);
        this.guiInitilaze(300, 300);
        this.brand = brand;
        this.brandManager = new BrandManager();

        if (brand != null) {
            this.fld_brand_name.setText(brand.getName());
        }
        btn_brand_save.addActionListener(e -> {
            if (Helper.isFieldEmpty(this.fld_brand_name)) {
                Helper.showMessage("fill");
            } else {
                boolean result;
                if (this.brand == null) {
                    Brand newBrand = new Brand(fld_brand_name.getText());
                    result = this.brandManager.save(newBrand);
                } else {
                    this.brand.setName(fld_brand_name.getText());
                    result = this.brandManager.update(this.brand);
                }

                if (result) {
                    Helper.showMessage("done");
                    dispose();
                } else {
                    Helper.showMessage("error");
                }
            }

        });
    }
}
