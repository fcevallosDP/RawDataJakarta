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
package org.primefaces.demo.service;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import org.primefaces.demo.domain.Photo;

@Named
@ApplicationScoped
public class PhotoService {

    private List<Photo> photos;

    @PostConstruct
    public void init() {
        photos = new ArrayList<>();

        photos.add(new Photo("demo/images/galleria/galleria1.jpg", "demo/images/galleria/galleria1s.jpg",
                "Description for Image 1", "Title 1"));
        photos.add(new Photo("demo/images/galleria/galleria2.jpg", "demo/images/galleria/galleria2s.jpg",
                "Description for Image 2", "Title 2"));
        photos.add(new Photo("demo/images/galleria/galleria3.jpg", "demo/images/galleria/galleria3s.jpg",
                "Description for Image 3", "Title 3"));
        photos.add(new Photo("demo/images/galleria/galleria4.jpg", "demo/images/galleria/galleria4s.jpg",
                "Description for Image 4", "Title 4"));
        photos.add(new Photo("demo/images/galleria/galleria5.jpg", "demo/images/galleria/galleria5s.jpg",
                "Description for Image 5", "Title 5"));
        photos.add(new Photo("demo/images/galleria/galleria6.jpg", "demo/images/galleria/galleria6s.jpg",
                "Description for Image 6", "Title 6"));
        photos.add(new Photo("demo/images/galleria/galleria7.jpg", "demo/images/galleria/galleria7s.jpg",
                "Description for Image 7", "Title 7"));
        photos.add(new Photo("demo/images/galleria/galleria8.jpg", "demo/images/galleria/galleria8s.jpg",
                "Description for Image 8", "Title 8"));
        photos.add(new Photo("demo/images/galleria/galleria9.jpg", "demo/images/galleria/galleria9s.jpg",
                "Description for Image 9", "Title 9"));
        photos.add(new Photo("demo/images/galleria/galleria10.jpg", "demo/images/galleria/galleria10s.jpg",
                "Description for Image 10", "Title 10"));
        photos.add(new Photo("demo/images/galleria/galleria11.jpg", "demo/images/galleria/galleria11s.jpg",
                "Description for Image 11", "Title 11"));
        photos.add(new Photo("demo/images/galleria/galleria12.jpg", "demo/images/galleria/galleria12s.jpg",
                "Description for Image 12", "Title 12"));
        photos.add(new Photo("demo/images/galleria/galleria13.jpg", "demo/images/galleria/galleria13s.jpg",
                "Description for Image 13", "Title 13"));
        photos.add(new Photo("demo/images/galleria/galleria14.jpg", "demo/images/galleria/galleria14s.jpg",
                "Description for Image 14", "Title 14"));
        photos.add(new Photo("demo/images/galleria/galleria15.jpg", "demo/images/galleria/galleria15s.jpg",
                "Description for Image 15", "Title 15"));
    }

    public List<Photo> getPhotos() {
        return photos;
    }
}
