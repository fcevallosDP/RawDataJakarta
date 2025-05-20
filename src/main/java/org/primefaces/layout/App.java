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

import java.io.Serializable;
import java.util.Map;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;
import org.primefaces.layout.enums.InputStyleType;
import org.primefaces.layout.enums.LayoutType;
import org.primefaces.layout.enums.MenuType;
import org.primefaces.layout.enums.InlineMenuType;
import org.primefaces.layout.util.StyleClassBuilder;

@Named
@SessionScoped
public class App implements Serializable {

    /********** LAYOUT OPTIONS **********/

    private String topbarTheme = "blue";

    private String menuTheme = "light";

    private String componentTheme = "indigo";

    private LayoutType layoutMode = LayoutType.LIGHT;

    private MenuType menuMode = MenuType.STATIC;

    private InlineMenuType inlineMenuPosition = InlineMenuType.BOTTOM;

    private InputStyleType inputStyle = InputStyleType.FILLED;

    private boolean ripple = true;

    private boolean rtl = false;

    /************************************/

    /** Theme and Layout */
    public String getTheme() {
        return this.componentTheme + (this.isDarkLayout() ? "-dark" : "");
    }

    public String getLayout() {
        return "layout-" + this.layoutMode.toString();
    }

    /** Layout Mode */
    public boolean isLightLayout() {
        return LayoutType.LIGHT.equals(this.layoutMode);
    }
    public boolean isDarkLayout() {
        return LayoutType.DARK.equals(this.layoutMode);
    }

    /** Menu Modes */
    public boolean isStaticMenu() {
        return MenuType.STATIC.equals(this.menuMode);
    }
    public boolean isOverlayMenu() {
        return MenuType.OVERLAY.equals(this.menuMode);
    }
    public boolean isHorizontalMenu() {
        return MenuType.HORIZONTAL.equals(this.menuMode);
    }
    public boolean isSlimMenu() {
        return MenuType.SLIM.equals(this.menuMode);
    }

    /** Inline Menu Positions */
    public boolean isTopInlineMenu() {
        return InlineMenuType.TOP.equals(this.inlineMenuPosition);
    }
    public boolean isBottomInlineMenu() {
        return InlineMenuType.BOTTOM.equals(this.inlineMenuPosition);
    }
    public boolean isBothInlineMenu() {
        return InlineMenuType.BOTH.equals(this.inlineMenuPosition);
    }

    /** InputStyle Modes */
    public boolean isFilledInputStyle() {
        return InputStyleType.FILLED.equals(this.inputStyle);
    }
    public boolean isOutlinedInputStyle() {
        return InputStyleType.OUTLINED.equals(this.inputStyle);
    }

    /** Layout Classes */
    public String getBodyClass() {
        return new StyleClassBuilder()
            .add(this.isFilledInputStyle(), "ui-input-filled")
            .add(!this.ripple, "ui-ripple-disabled")
            .build();
    }

    public String getLayoutClass() {
        return new StyleClassBuilder()
            .add(this.isStaticMenu(), "layout-menu-static")
            .add(this.isOverlayMenu(), "layout-menu-overlay")
            .add(this.isHorizontalMenu(), "layout-menu-horizontal")
            .add(this.isSlimMenu(), "layout-menu-slim")
            .add(this.rtl, "layout-rtl")
            .add(this.menuTheme != null, "layout-menu-" + this.menuTheme)
            .add(this.topbarTheme != null, "layout-topbar-" + this.topbarTheme)
            .build();
    }

    /** App Logo */
    public boolean isLogoLight() {
        switch(this.topbarTheme) {
            case "white":
            case "yellow":
            case "amber":
            case "orange":
            case "lime":
                return false;
            default:
                return true;
        }
    }

    /** App BreadCrumb */
    public MenuModel getBreadCrumbModel() {
        Map<String, Object> params = FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
        Object homeOutcome = params.get("homeOutcome");
        Object value = params.get("value");
        Object outcome = params.get("outcome");

        MenuModel model = new DefaultMenuModel();

        DefaultMenuItem item = new DefaultMenuItem();
        item.setIcon("pi pi-home");
        if (homeOutcome != null) item.setOutcome(String.valueOf(homeOutcome));

        model.getElements().add(item);

        if (value != null) {
            String[] parts = String.valueOf(value).split(",");

            for(int i = 0; i < parts.length; i++) {
                DefaultMenuItem pageItem = new DefaultMenuItem();

                pageItem.setValue(parts[i]);
                if (outcome != null && i == (parts.length - 1)) pageItem.setOutcome(String.valueOf(outcome));

                model.getElements().add(pageItem);
            }
        }

        return model;
    }

    /******* Getter and Setters ******/
    public void setComponentTheme(String componentTheme) {
        this.componentTheme = componentTheme;
    }

    public String getComponentTheme() {
        return this.componentTheme;
    }

    public void setTopbarTheme(String topbarTheme) {
        this.topbarTheme = topbarTheme;
    }

    public String getTopbarTheme() {
        return this.topbarTheme;
    }

    public void setMenuTheme(String menuTheme) {
	this.menuTheme = menuTheme;
    }

    public String getMenuTheme() {
	return this.menuTheme;
    }

    public void setLayoutMode(LayoutType layoutMode) {
        this.layoutMode = layoutMode;

        if (isDarkLayout()) {
            this.menuTheme = "dark";
            this.topbarTheme = "dark";
        }
        else {
            this.menuTheme = "light";
            this.topbarTheme = "blue";
        }
    }

    public LayoutType getLayoutMode() {
        return this.layoutMode;
    }

    public void setMenuMode(MenuType menuMode) {
        this.menuMode = menuMode;
    }

    public MenuType getMenuMode() {
        return this.menuMode;
    }

    public void setInlineMenuPosition(InlineMenuType inlineMenuPosition) {
        this.inlineMenuPosition = inlineMenuPosition;
    }

    public InlineMenuType getInlineMenuPosition() {
        return this.inlineMenuPosition;
    }

    public void setInputStyle(InputStyleType inputStyle) {
        this.inputStyle= inputStyle;
    }

    public InputStyleType getInputStyle() {
        return this.inputStyle;
    }

    public void setRipple(boolean ripple) {
        this.ripple = ripple;
    }

    public boolean isRipple() {
        return this.ripple;
    }

    public void setRtl(boolean rtl) {
        this.rtl = rtl;
    }

    public boolean isRtl() {
        return this.rtl;
    }
}
