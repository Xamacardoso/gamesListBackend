package com.xamacardoso.gamesList.projections;

// Projection is an interface for returning only a set of attributes
// that are retrieved by a repository query, instead of the whole entity.
public interface GameMinProjection {
    Long getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
}
