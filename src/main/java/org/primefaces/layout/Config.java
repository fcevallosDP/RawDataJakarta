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
package org.primefaces.layout;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.annotation.PostConstruct;

@Named
@ViewScoped
public class Config implements Serializable {

    private List<Color> themes;

    private List<Color> menuThemes;

    private List<Color> topbarThemes;
    
    @PostConstruct
    public void init() {
        themes = new ArrayList<>();
        themes.add(new Color("indigo", "#3F51B5"));
        themes.add(new Color("pink", "#E91E63"));
        themes.add(new Color("purple", "#9C27B0"));
        themes.add(new Color("deeppurple", "#673AB7"));
        themes.add(new Color("blue", "#2196F3"));
        themes.add(new Color("lightblue", "#03A9F4"));
        themes.add(new Color("cyan", "#00BCD4"));
        themes.add(new Color("teal", "#009688"));
        themes.add(new Color("green", "#4CAF50"));
        themes.add(new Color("lightgreen", "#8BC34A"));
        themes.add(new Color("lime", "#CDDC39"));
        themes.add(new Color("yellow", "#FFEB3B"));
        themes.add(new Color("amber", "#FFC107"));
        themes.add(new Color("orange", "#FF9800"));
        themes.add(new Color("deeporange", "#FF5722"));
        themes.add(new Color("brown", "#795548"));
        themes.add(new Color("bluegrey", "#607D8B"));

        menuThemes = new ArrayList<>();
        menuThemes.add(new Color("light", "#FDFEFF"));
        menuThemes.add(new Color("dark", "#434B54"));
        menuThemes.add(new Color("indigo", "#1A237E"));
        menuThemes.add(new Color("bluegrey", "#37474F"));
        menuThemes.add(new Color("brown", "#4E342E"));
        menuThemes.add(new Color("cyan", "#006064"));
        menuThemes.add(new Color("green", "#2E7D32"));
        menuThemes.add(new Color("deeppurple", "#4527A0"));
        menuThemes.add(new Color("deeporange", "#BF360C"));
        menuThemes.add(new Color("pink", "#880E4F"));
        menuThemes.add(new Color("purple", "#6A1B9A"));
        menuThemes.add(new Color("teal", "#00695C"));

        topbarThemes = new ArrayList<>();
        topbarThemes.add(new Color("lightblue", "#2E88FF"));
        topbarThemes.add(new Color("dark", "#363636"));
        topbarThemes.add(new Color("white", "#FDFEFF"));
        topbarThemes.add(new Color("blue", "#1565C0"));
        topbarThemes.add(new Color("deeppurple", "#4527A0"));
        topbarThemes.add(new Color("purple", "#6A1B9A"));
        topbarThemes.add(new Color("pink", "#AD1457"));
        topbarThemes.add(new Color("cyan", "#0097A7"));
        topbarThemes.add(new Color("teal", "#00796B"));
        topbarThemes.add(new Color("green", "#43A047"));
        topbarThemes.add(new Color("lightgreen", "#689F38"));
        topbarThemes.add(new Color("lime", "#AFB42B"));
        topbarThemes.add(new Color("yellow", "#FBC02D"));
        topbarThemes.add(new Color("amber", "#FFA000"));
        topbarThemes.add(new Color("orange", "#FB8C00"));
        topbarThemes.add(new Color("deeporange", "#D84315"));
        topbarThemes.add(new Color("brown", "#5D4037"));
        topbarThemes.add(new Color("grey", "#616161"));
        topbarThemes.add(new Color("bluegrey", "#546E7A"));
        topbarThemes.add(new Color("indigo", "#3F51B5"));
    }

    public List<Color> getThemes() {
        return themes;
    }

    public List<Color> getMenuThemes() {
        return menuThemes;
    }

    public List<Color> getTopbarThemes() {
        return topbarThemes;
    }

    public static class Color {
        private String name;
        private String value;

        public Color() {
        }

        public Color(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}