package com.amazonaws.appflow.custom.connector.model.connectorconfiguration.auth;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link OAuth2Defaults}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableOAuth2Defaults.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableOAuth2Defaults
    implements OAuth2Defaults {
  private final @Nullable ImmutableList<String> oAuthScopes;
  private final ImmutableList<String> tokenURL;
  private final @Nullable ImmutableList<String> authURL;
  private final ImmutableList<OAuth2GrantType> oAuth2GrantTypesSupported;

  private ImmutableOAuth2Defaults(
      @Nullable ImmutableList<String> oAuthScopes,
      ImmutableList<String> tokenURL,
      @Nullable ImmutableList<String> authURL,
      ImmutableList<OAuth2GrantType> oAuth2GrantTypesSupported) {
    this.oAuthScopes = oAuthScopes;
    this.tokenURL = tokenURL;
    this.authURL = authURL;
    this.oAuth2GrantTypesSupported = oAuth2GrantTypesSupported;
  }

  /**
   * OAuth Scopes. Required for OAuth2GrantType - AUTHORIZATION_CODE.
   */
  @JsonProperty("oAuthScopes")
  @Override
  public @Nullable ImmutableList<String> oAuthScopes() {
    return oAuthScopes;
  }

  /**
   * Token URLs. Required for both OAuth2GrantType - AUTHORIZATION_CODE and CLIENT_CREDENTIALS.
   */
  @JsonProperty("tokenURL")
  @Override
  public ImmutableList<String> tokenURL() {
    return tokenURL;
  }

  /**
   * Auth URLs. Required for OAuth2GrantType - AUTHORIZATION_CODE.
   */
  @JsonProperty("authURL")
  @Override
  public @Nullable ImmutableList<String> authURL() {
    return authURL;
  }

  /**
   * OAuth2 Grant types supported by connector.
   */
  @JsonProperty("oAuth2GrantTypesSupported")
  @Override
  public ImmutableList<OAuth2GrantType> oAuth2GrantTypesSupported() {
    return oAuth2GrantTypesSupported;
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link OAuth2Defaults#oAuthScopes() oAuthScopes}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOAuth2Defaults withOAuthScopes(@Nullable String... elements) {
    if (elements == null) {
      return new ImmutableOAuth2Defaults(null, this.tokenURL, this.authURL, this.oAuth2GrantTypesSupported);
    }
    @Nullable ImmutableList<String> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableOAuth2Defaults(newValue, this.tokenURL, this.authURL, this.oAuth2GrantTypesSupported);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link OAuth2Defaults#oAuthScopes() oAuthScopes}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of oAuthScopes elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOAuth2Defaults withOAuthScopes(@Nullable Iterable<String> elements) {
    if (this.oAuthScopes == elements) return this;
    @Nullable ImmutableList<String> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableOAuth2Defaults(newValue, this.tokenURL, this.authURL, this.oAuth2GrantTypesSupported);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link OAuth2Defaults#tokenURL() tokenURL}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOAuth2Defaults withTokenURL(String... elements) {
    ImmutableList<String> newValue = ImmutableList.copyOf(elements);
    return new ImmutableOAuth2Defaults(this.oAuthScopes, newValue, this.authURL, this.oAuth2GrantTypesSupported);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link OAuth2Defaults#tokenURL() tokenURL}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of tokenURL elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOAuth2Defaults withTokenURL(Iterable<String> elements) {
    if (this.tokenURL == elements) return this;
    ImmutableList<String> newValue = ImmutableList.copyOf(elements);
    return new ImmutableOAuth2Defaults(this.oAuthScopes, newValue, this.authURL, this.oAuth2GrantTypesSupported);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link OAuth2Defaults#authURL() authURL}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOAuth2Defaults withAuthURL(@Nullable String... elements) {
    if (elements == null) {
      return new ImmutableOAuth2Defaults(this.oAuthScopes, this.tokenURL, null, this.oAuth2GrantTypesSupported);
    }
    @Nullable ImmutableList<String> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableOAuth2Defaults(this.oAuthScopes, this.tokenURL, newValue, this.oAuth2GrantTypesSupported);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link OAuth2Defaults#authURL() authURL}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of authURL elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOAuth2Defaults withAuthURL(@Nullable Iterable<String> elements) {
    if (this.authURL == elements) return this;
    @Nullable ImmutableList<String> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableOAuth2Defaults(this.oAuthScopes, this.tokenURL, newValue, this.oAuth2GrantTypesSupported);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link OAuth2Defaults#oAuth2GrantTypesSupported() oAuth2GrantTypesSupported}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOAuth2Defaults withOAuth2GrantTypesSupported(OAuth2GrantType... elements) {
    ImmutableList<OAuth2GrantType> newValue = ImmutableList.copyOf(elements);
    return new ImmutableOAuth2Defaults(this.oAuthScopes, this.tokenURL, this.authURL, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link OAuth2Defaults#oAuth2GrantTypesSupported() oAuth2GrantTypesSupported}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of oAuth2GrantTypesSupported elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOAuth2Defaults withOAuth2GrantTypesSupported(Iterable<? extends OAuth2GrantType> elements) {
    if (this.oAuth2GrantTypesSupported == elements) return this;
    ImmutableList<OAuth2GrantType> newValue = ImmutableList.copyOf(elements);
    return new ImmutableOAuth2Defaults(this.oAuthScopes, this.tokenURL, this.authURL, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableOAuth2Defaults} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableOAuth2Defaults
        && equalTo((ImmutableOAuth2Defaults) another);
  }

  private boolean equalTo(ImmutableOAuth2Defaults another) {
    return Objects.equal(oAuthScopes, another.oAuthScopes)
        && tokenURL.equals(another.tokenURL)
        && Objects.equal(authURL, another.authURL)
        && oAuth2GrantTypesSupported.equals(another.oAuth2GrantTypesSupported);
  }

  /**
   * Computes a hash code from attributes: {@code oAuthScopes}, {@code tokenURL}, {@code authURL}, {@code oAuth2GrantTypesSupported}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Objects.hashCode(oAuthScopes);
    h = h * 17 + tokenURL.hashCode();
    h = h * 17 + Objects.hashCode(authURL);
    h = h * 17 + oAuth2GrantTypesSupported.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code OAuth2Defaults} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("OAuth2Defaults")
        .omitNullValues()
        .add("oAuthScopes", oAuthScopes)
        .add("tokenURL", tokenURL)
        .add("authURL", authURL)
        .add("oAuth2GrantTypesSupported", oAuth2GrantTypesSupported)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json
      implements OAuth2Defaults {
    List<String> oAuthScopes = null;
    List<String> tokenURL = ImmutableList.of();
    List<String> authURL = null;
    List<OAuth2GrantType> oAuth2GrantTypesSupported = ImmutableList.of();
    @JsonProperty("oAuthScopes")
    public void setOAuthScopes(@Nullable List<String> oAuthScopes) {
      this.oAuthScopes = oAuthScopes;
    }
    @JsonProperty("tokenURL")
    public void setTokenURL(List<String> tokenURL) {
      this.tokenURL = tokenURL;
    }
    @JsonProperty("authURL")
    public void setAuthURL(@Nullable List<String> authURL) {
      this.authURL = authURL;
    }
    @JsonProperty("oAuth2GrantTypesSupported")
    public void setOAuth2GrantTypesSupported(List<OAuth2GrantType> oAuth2GrantTypesSupported) {
      this.oAuth2GrantTypesSupported = oAuth2GrantTypesSupported;
    }
    @Override
    public List<String> oAuthScopes() { throw new UnsupportedOperationException(); }
    @Override
    public List<String> tokenURL() { throw new UnsupportedOperationException(); }
    @Override
    public List<String> authURL() { throw new UnsupportedOperationException(); }
    @Override
    public List<OAuth2GrantType> oAuth2GrantTypesSupported() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableOAuth2Defaults fromJson(Json json) {
    ImmutableOAuth2Defaults.Builder builder = ImmutableOAuth2Defaults.builder();
    if (json.oAuthScopes != null) {
      builder.addAllOAuthScopes(json.oAuthScopes);
    }
    if (json.tokenURL != null) {
      builder.addAllTokenURL(json.tokenURL);
    }
    if (json.authURL != null) {
      builder.addAllAuthURL(json.authURL);
    }
    if (json.oAuth2GrantTypesSupported != null) {
      builder.addAllOAuth2GrantTypesSupported(json.oAuth2GrantTypesSupported);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link OAuth2Defaults} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable OAuth2Defaults instance
   */
  public static ImmutableOAuth2Defaults copyOf(OAuth2Defaults instance) {
    if (instance instanceof ImmutableOAuth2Defaults) {
      return (ImmutableOAuth2Defaults) instance;
    }
    return ImmutableOAuth2Defaults.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableOAuth2Defaults ImmutableOAuth2Defaults}.
   * @return A new ImmutableOAuth2Defaults builder
   */
  public static ImmutableOAuth2Defaults.Builder builder() {
    return new ImmutableOAuth2Defaults.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableOAuth2Defaults ImmutableOAuth2Defaults}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private ImmutableList.Builder<String> oAuthScopes = null;
    private ImmutableList.Builder<String> tokenURL = ImmutableList.builder();
    private ImmutableList.Builder<String> authURL = null;
    private ImmutableList.Builder<OAuth2GrantType> oAuth2GrantTypesSupported = ImmutableList.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code OAuth2Defaults} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(OAuth2Defaults instance) {
      Preconditions.checkNotNull(instance, "instance");
      @Nullable List<String> oAuthScopesValue = instance.oAuthScopes();
      if (oAuthScopesValue != null) {
        addAllOAuthScopes(oAuthScopesValue);
      }
      addAllTokenURL(instance.tokenURL());
      @Nullable List<String> authURLValue = instance.authURL();
      if (authURLValue != null) {
        addAllAuthURL(authURLValue);
      }
      addAllOAuth2GrantTypesSupported(instance.oAuth2GrantTypesSupported());
      return this;
    }

    /**
     * Adds one element to {@link OAuth2Defaults#oAuthScopes() oAuthScopes} list.
     * @param element A oAuthScopes element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addOAuthScopes(String element) {
      if (this.oAuthScopes == null) {
        this.oAuthScopes = ImmutableList.builder();
      }
      this.oAuthScopes.add(element);
      return this;
    }

    /**
     * Adds elements to {@link OAuth2Defaults#oAuthScopes() oAuthScopes} list.
     * @param elements An array of oAuthScopes elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addOAuthScopes(String... elements) {
      if (this.oAuthScopes == null) {
        this.oAuthScopes = ImmutableList.builder();
      }
      this.oAuthScopes.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link OAuth2Defaults#oAuthScopes() oAuthScopes} list.
     * @param elements An iterable of oAuthScopes elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder oAuthScopes(@Nullable Iterable<String> elements) {
      if (elements == null) {
        this.oAuthScopes = null;
        return this;
      }
      this.oAuthScopes = ImmutableList.builder();
      return addAllOAuthScopes(elements);
    }

    /**
     * Adds elements to {@link OAuth2Defaults#oAuthScopes() oAuthScopes} list.
     * @param elements An iterable of oAuthScopes elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllOAuthScopes(Iterable<String> elements) {
      Preconditions.checkNotNull(elements, "oAuthScopes element");
      if (this.oAuthScopes == null) {
        this.oAuthScopes = ImmutableList.builder();
      }
      this.oAuthScopes.addAll(elements);
      return this;
    }

    /**
     * Adds one element to {@link OAuth2Defaults#tokenURL() tokenURL} list.
     * @param element A tokenURL element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addTokenURL(String element) {
      this.tokenURL.add(element);
      return this;
    }

    /**
     * Adds elements to {@link OAuth2Defaults#tokenURL() tokenURL} list.
     * @param elements An array of tokenURL elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addTokenURL(String... elements) {
      this.tokenURL.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link OAuth2Defaults#tokenURL() tokenURL} list.
     * @param elements An iterable of tokenURL elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder tokenURL(Iterable<String> elements) {
      this.tokenURL = ImmutableList.builder();
      return addAllTokenURL(elements);
    }

    /**
     * Adds elements to {@link OAuth2Defaults#tokenURL() tokenURL} list.
     * @param elements An iterable of tokenURL elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllTokenURL(Iterable<String> elements) {
      this.tokenURL.addAll(elements);
      return this;
    }

    /**
     * Adds one element to {@link OAuth2Defaults#authURL() authURL} list.
     * @param element A authURL element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAuthURL(String element) {
      if (this.authURL == null) {
        this.authURL = ImmutableList.builder();
      }
      this.authURL.add(element);
      return this;
    }

    /**
     * Adds elements to {@link OAuth2Defaults#authURL() authURL} list.
     * @param elements An array of authURL elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAuthURL(String... elements) {
      if (this.authURL == null) {
        this.authURL = ImmutableList.builder();
      }
      this.authURL.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link OAuth2Defaults#authURL() authURL} list.
     * @param elements An iterable of authURL elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder authURL(@Nullable Iterable<String> elements) {
      if (elements == null) {
        this.authURL = null;
        return this;
      }
      this.authURL = ImmutableList.builder();
      return addAllAuthURL(elements);
    }

    /**
     * Adds elements to {@link OAuth2Defaults#authURL() authURL} list.
     * @param elements An iterable of authURL elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllAuthURL(Iterable<String> elements) {
      Preconditions.checkNotNull(elements, "authURL element");
      if (this.authURL == null) {
        this.authURL = ImmutableList.builder();
      }
      this.authURL.addAll(elements);
      return this;
    }

    /**
     * Adds one element to {@link OAuth2Defaults#oAuth2GrantTypesSupported() oAuth2GrantTypesSupported} list.
     * @param element A oAuth2GrantTypesSupported element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addOAuth2GrantTypesSupported(OAuth2GrantType element) {
      this.oAuth2GrantTypesSupported.add(element);
      return this;
    }

    /**
     * Adds elements to {@link OAuth2Defaults#oAuth2GrantTypesSupported() oAuth2GrantTypesSupported} list.
     * @param elements An array of oAuth2GrantTypesSupported elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addOAuth2GrantTypesSupported(OAuth2GrantType... elements) {
      this.oAuth2GrantTypesSupported.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link OAuth2Defaults#oAuth2GrantTypesSupported() oAuth2GrantTypesSupported} list.
     * @param elements An iterable of oAuth2GrantTypesSupported elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder oAuth2GrantTypesSupported(Iterable<? extends OAuth2GrantType> elements) {
      this.oAuth2GrantTypesSupported = ImmutableList.builder();
      return addAllOAuth2GrantTypesSupported(elements);
    }

    /**
     * Adds elements to {@link OAuth2Defaults#oAuth2GrantTypesSupported() oAuth2GrantTypesSupported} list.
     * @param elements An iterable of oAuth2GrantTypesSupported elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllOAuth2GrantTypesSupported(Iterable<? extends OAuth2GrantType> elements) {
      this.oAuth2GrantTypesSupported.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutableOAuth2Defaults ImmutableOAuth2Defaults}.
     * @return An immutable instance of OAuth2Defaults
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableOAuth2Defaults build() {
      return new ImmutableOAuth2Defaults(
          oAuthScopes == null ? null : oAuthScopes.build(),
          tokenURL.build(),
          authURL == null ? null : authURL.build(),
          oAuth2GrantTypesSupported.build());
    }
  }
}
