/*
 *  Copyright 2009-2022 PrimeTek.
 *
 *  Licensed under PrimeFaces Commercial License, Version 1.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  Licensed under PrimeFaces Commercial License, Version 1.0 (the "License");
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.primefaces.demo.view.pages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class InvoiceDemoView {

    private List<Bill> billData;
    private List<Product> productData;

    @PostConstruct
    public void init() {
        billData = new ArrayList<>();
        billData.add(new Bill("TOYOKSU SYSCOM CORPORATION 11-27, MEIEKI 4-CHROME NAKAMURA-KU, NAGOYA 450-0002 JAPAN", "30/08/2021", "A/3100", "N/A"));

        productData = new ArrayList<>();
        productData.add(new Product("License A", "4", "$99.00", "$396.00"));
        productData.add(new Product("License B", "1", "$790.00", "$790.00"));
        productData.add(new Product("License C", "2", "$59.00", "$118.00"));
    }

    public List<Bill> getBillData() {
        return billData;
    }

    public void setBillData(List<Bill> billData) {
        this.billData = billData;
    }

    public List<Product> getProductData() {
        return productData;
    }

    public void setProductData(List<Product> productData) {
        this.productData = productData;
    }

    public static class Bill implements Serializable {
        private String to;
        private String date;
        private String no;
        private String notes;

        public Bill() { 
        }

        public Bill(String to, String date, String no, String notes) {
            this.to = to;
            this.date = date;
            this.no = no;
            this.notes = notes;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }
    }

    public static class Product implements Serializable {
        private String description;
        private String quantity;
        private String price;
        private String total;

        public Product() { 
        }

        public Product(String description, String quantity, String price, String total) {
            this.description = description;
            this.quantity = quantity;
            this.price = price;
            this.total = total;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }
    }
}