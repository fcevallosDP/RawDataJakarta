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
package org.primefaces.demo.domain;

import java.io.Serializable;

public class Photo implements Serializable {

    private String itemImageSrc;
    private String thumbnailImageSrc;
    private String alt;
    private String title;

    public Photo() {
    }

    public Photo(String itemImageSrc, String thumbnailImageSrc, String alt, String title) {
        this.itemImageSrc = itemImageSrc;
        this.thumbnailImageSrc = thumbnailImageSrc;
        this.alt = alt;
        this.title = title;
    }

    public String getItemImageSrc() {
        return itemImageSrc;
    }

    public void setItemImageSrc(String itemImageSrc) {
        this.itemImageSrc = itemImageSrc;
    }

    public String getThumbnailImageSrc() {
        return thumbnailImageSrc;
    }

    public void setThumbnailImageSrc(String thumbnailImageSrc) {
        this.thumbnailImageSrc = thumbnailImageSrc;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
