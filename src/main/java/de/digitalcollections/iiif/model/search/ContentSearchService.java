package de.digitalcollections.iiif.model.search;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.digitalcollections.iiif.model.Service;
import java.net.URI;

public class ContentSearchService extends Service {
  public static final String CONTEXT = "http://iiif.io/api/search/1/context.json";

  @JsonProperty("service")
  private AutocompleteService autocompleteService;

  @JsonCreator
  public ContentSearchService(@JsonProperty("@id") String identifier) {
    super(URI.create(CONTEXT));
    this.setIdentifier(URI.create(identifier));
    this.addProfile("http://iiif.io/api/search/1/search");
  }

  public AutocompleteService getAutocompleteService() {
    return autocompleteService;
  }

  public void addAutocompleteService(String identifier) {
    this.autocompleteService = new AutocompleteService(URI.create(identifier));
  }
}
