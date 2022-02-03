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
 * Immutable implementation of {@link AuthenticationConfig}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableAuthenticationConfig.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableAuthenticationConfig
    implements AuthenticationConfig {
  private final @Nullable Boolean isBasicAuthSupported;
  private final @Nullable Boolean isApiKeyAuthSupported;
  private final @Nullable Boolean isOAuth2Supported;
  private final @Nullable Boolean isCustomAuthSupported;
  private final @Nullable OAuth2Defaults oAuth2Defaults;
  private final @Nullable ImmutableList<CustomAuthConfig> customAuthConfig;

  private ImmutableAuthenticationConfig(
      @Nullable Boolean isBasicAuthSupported,
      @Nullable Boolean isApiKeyAuthSupported,
      @Nullable Boolean isOAuth2Supported,
      @Nullable Boolean isCustomAuthSupported,
      @Nullable OAuth2Defaults oAuth2Defaults,
      @Nullable ImmutableList<CustomAuthConfig> customAuthConfig) {
    this.isBasicAuthSupported = isBasicAuthSupported;
    this.isApiKeyAuthSupported = isApiKeyAuthSupported;
    this.isOAuth2Supported = isOAuth2Supported;
    this.isCustomAuthSupported = isCustomAuthSupported;
    this.oAuth2Defaults = oAuth2Defaults;
    this.customAuthConfig = customAuthConfig;
  }

  /**
   * Specifies if the Basic Auth is supported by connector.
   */
  @JsonProperty("isBasicAuthSupported")
  @Override
  public @Nullable Boolean isBasicAuthSupported() {
    return isBasicAuthSupported;
  }

  /**
   * Specifies if the ApiKey Auth is supported by connector.
   */
  @JsonProperty("isApiKeyAuthSupported")
  @Override
  public @Nullable Boolean isApiKeyAuthSupported() {
    return isApiKeyAuthSupported;
  }

  /**
   * Specifies if the OAuth2 is supported by connector.
   */
  @JsonProperty("isOAuth2Supported")
  @Override
  public @Nullable Boolean isOAuth2Supported() {
    return isOAuth2Supported;
  }

  /**
   * Specifies if the Custom Authentication is supported by connector.
   */
  @JsonProperty("isCustomAuthSupported")
  @Override
  public @Nullable Boolean isCustomAuthSupported() {
    return isCustomAuthSupported;
  }

  /**
   * OAuth2 default values provided by the connector.
   */
  @JsonProperty("oAuth2Defaults")
  @Override
  public @Nullable OAuth2Defaults oAuth2Defaults() {
    return oAuth2Defaults;
  }

  /**
   * Configuration for custom Authentication defined by the connector.
   */
  @JsonProperty("customAuthConfig")
  @Override
  public @Nullable ImmutableList<CustomAuthConfig> customAuthConfig() {
    return customAuthConfig;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AuthenticationConfig#isBasicAuthSupported() isBasicAuthSupported} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param isBasicAuthSupported A new value for isBasicAuthSupported (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAuthenticationConfig withIsBasicAuthSupported(@Nullable Boolean isBasicAuthSupported) {
    if (Objects.equal(this.isBasicAuthSupported, isBasicAuthSupported)) return this;
    return new ImmutableAuthenticationConfig(
        isBasicAuthSupported,
        this.isApiKeyAuthSupported,
        this.isOAuth2Supported,
        this.isCustomAuthSupported,
        this.oAuth2Defaults,
        this.customAuthConfig);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AuthenticationConfig#isApiKeyAuthSupported() isApiKeyAuthSupported} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param isApiKeyAuthSupported A new value for isApiKeyAuthSupported (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAuthenticationConfig withIsApiKeyAuthSupported(@Nullable Boolean isApiKeyAuthSupported) {
    if (Objects.equal(this.isApiKeyAuthSupported, isApiKeyAuthSupported)) return this;
    return new ImmutableAuthenticationConfig(
        this.isBasicAuthSupported,
        isApiKeyAuthSupported,
        this.isOAuth2Supported,
        this.isCustomAuthSupported,
        this.oAuth2Defaults,
        this.customAuthConfig);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AuthenticationConfig#isOAuth2Supported() isOAuth2Supported} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param isOAuth2Supported A new value for isOAuth2Supported (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAuthenticationConfig withIsOAuth2Supported(@Nullable Boolean isOAuth2Supported) {
    if (Objects.equal(this.isOAuth2Supported, isOAuth2Supported)) return this;
    return new ImmutableAuthenticationConfig(
        this.isBasicAuthSupported,
        this.isApiKeyAuthSupported,
        isOAuth2Supported,
        this.isCustomAuthSupported,
        this.oAuth2Defaults,
        this.customAuthConfig);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AuthenticationConfig#isCustomAuthSupported() isCustomAuthSupported} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param isCustomAuthSupported A new value for isCustomAuthSupported (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAuthenticationConfig withIsCustomAuthSupported(@Nullable Boolean isCustomAuthSupported) {
    if (Objects.equal(this.isCustomAuthSupported, isCustomAuthSupported)) return this;
    return new ImmutableAuthenticationConfig(
        this.isBasicAuthSupported,
        this.isApiKeyAuthSupported,
        this.isOAuth2Supported,
        isCustomAuthSupported,
        this.oAuth2Defaults,
        this.customAuthConfig);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AuthenticationConfig#oAuth2Defaults() oAuth2Defaults} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param oAuth2Defaults A new value for oAuth2Defaults (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAuthenticationConfig withOAuth2Defaults(@Nullable OAuth2Defaults oAuth2Defaults) {
    if (this.oAuth2Defaults == oAuth2Defaults) return this;
    return new ImmutableAuthenticationConfig(
        this.isBasicAuthSupported,
        this.isApiKeyAuthSupported,
        this.isOAuth2Supported,
        this.isCustomAuthSupported,
        oAuth2Defaults,
        this.customAuthConfig);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link AuthenticationConfig#customAuthConfig() customAuthConfig}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableAuthenticationConfig withCustomAuthConfig(@Nullable CustomAuthConfig... elements) {
    if (elements == null) {
      return new ImmutableAuthenticationConfig(
          this.isBasicAuthSupported,
          this.isApiKeyAuthSupported,
          this.isOAuth2Supported,
          this.isCustomAuthSupported,
          this.oAuth2Defaults,
          null);
    }
    @Nullable ImmutableList<CustomAuthConfig> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableAuthenticationConfig(
        this.isBasicAuthSupported,
        this.isApiKeyAuthSupported,
        this.isOAuth2Supported,
        this.isCustomAuthSupported,
        this.oAuth2Defaults,
        newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link AuthenticationConfig#customAuthConfig() customAuthConfig}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of customAuthConfig elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableAuthenticationConfig withCustomAuthConfig(@Nullable Iterable<? extends CustomAuthConfig> elements) {
    if (this.customAuthConfig == elements) return this;
    @Nullable ImmutableList<CustomAuthConfig> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableAuthenticationConfig(
        this.isBasicAuthSupported,
        this.isApiKeyAuthSupported,
        this.isOAuth2Supported,
        this.isCustomAuthSupported,
        this.oAuth2Defaults,
        newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableAuthenticationConfig} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableAuthenticationConfig
        && equalTo((ImmutableAuthenticationConfig) another);
  }

  private boolean equalTo(ImmutableAuthenticationConfig another) {
    return Objects.equal(isBasicAuthSupported, another.isBasicAuthSupported)
        && Objects.equal(isApiKeyAuthSupported, another.isApiKeyAuthSupported)
        && Objects.equal(isOAuth2Supported, another.isOAuth2Supported)
        && Objects.equal(isCustomAuthSupported, another.isCustomAuthSupported)
        && Objects.equal(oAuth2Defaults, another.oAuth2Defaults)
        && Objects.equal(customAuthConfig, another.customAuthConfig);
  }

  /**
   * Computes a hash code from attributes: {@code isBasicAuthSupported}, {@code isApiKeyAuthSupported}, {@code isOAuth2Supported}, {@code isCustomAuthSupported}, {@code oAuth2Defaults}, {@code customAuthConfig}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Objects.hashCode(isBasicAuthSupported);
    h = h * 17 + Objects.hashCode(isApiKeyAuthSupported);
    h = h * 17 + Objects.hashCode(isOAuth2Supported);
    h = h * 17 + Objects.hashCode(isCustomAuthSupported);
    h = h * 17 + Objects.hashCode(oAuth2Defaults);
    h = h * 17 + Objects.hashCode(customAuthConfig);
    return h;
  }

  /**
   * Prints the immutable value {@code AuthenticationConfig} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("AuthenticationConfig")
        .omitNullValues()
        .add("isBasicAuthSupported", isBasicAuthSupported)
        .add("isApiKeyAuthSupported", isApiKeyAuthSupported)
        .add("isOAuth2Supported", isOAuth2Supported)
        .add("isCustomAuthSupported", isCustomAuthSupported)
        .add("oAuth2Defaults", oAuth2Defaults)
        .add("customAuthConfig", customAuthConfig)
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
      implements AuthenticationConfig {
    @Nullable Boolean isBasicAuthSupported;
    @Nullable Boolean isApiKeyAuthSupported;
    @Nullable Boolean isOAuth2Supported;
    @Nullable Boolean isCustomAuthSupported;
    @Nullable OAuth2Defaults oAuth2Defaults;
    List<CustomAuthConfig> customAuthConfig = null;
    @JsonProperty("isBasicAuthSupported")
    public void setIsBasicAuthSupported(@Nullable Boolean isBasicAuthSupported) {
      this.isBasicAuthSupported = isBasicAuthSupported;
    }
    @JsonProperty("isApiKeyAuthSupported")
    public void setIsApiKeyAuthSupported(@Nullable Boolean isApiKeyAuthSupported) {
      this.isApiKeyAuthSupported = isApiKeyAuthSupported;
    }
    @JsonProperty("isOAuth2Supported")
    public void setIsOAuth2Supported(@Nullable Boolean isOAuth2Supported) {
      this.isOAuth2Supported = isOAuth2Supported;
    }
    @JsonProperty("isCustomAuthSupported")
    public void setIsCustomAuthSupported(@Nullable Boolean isCustomAuthSupported) {
      this.isCustomAuthSupported = isCustomAuthSupported;
    }
    @JsonProperty("oAuth2Defaults")
    public void setOAuth2Defaults(@Nullable OAuth2Defaults oAuth2Defaults) {
      this.oAuth2Defaults = oAuth2Defaults;
    }
    @JsonProperty("customAuthConfig")
    public void setCustomAuthConfig(@Nullable List<CustomAuthConfig> customAuthConfig) {
      this.customAuthConfig = customAuthConfig;
    }
    @Override
    public Boolean isBasicAuthSupported() { throw new UnsupportedOperationException(); }
    @Override
    public Boolean isApiKeyAuthSupported() { throw new UnsupportedOperationException(); }
    @Override
    public Boolean isOAuth2Supported() { throw new UnsupportedOperationException(); }
    @Override
    public Boolean isCustomAuthSupported() { throw new UnsupportedOperationException(); }
    @Override
    public OAuth2Defaults oAuth2Defaults() { throw new UnsupportedOperationException(); }
    @Override
    public List<CustomAuthConfig> customAuthConfig() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableAuthenticationConfig fromJson(Json json) {
    ImmutableAuthenticationConfig.Builder builder = ImmutableAuthenticationConfig.builder();
    if (json.isBasicAuthSupported != null) {
      builder.isBasicAuthSupported(json.isBasicAuthSupported);
    }
    if (json.isApiKeyAuthSupported != null) {
      builder.isApiKeyAuthSupported(json.isApiKeyAuthSupported);
    }
    if (json.isOAuth2Supported != null) {
      builder.isOAuth2Supported(json.isOAuth2Supported);
    }
    if (json.isCustomAuthSupported != null) {
      builder.isCustomAuthSupported(json.isCustomAuthSupported);
    }
    if (json.oAuth2Defaults != null) {
      builder.oAuth2Defaults(json.oAuth2Defaults);
    }
    if (json.customAuthConfig != null) {
      builder.addAllCustomAuthConfig(json.customAuthConfig);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link AuthenticationConfig} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable AuthenticationConfig instance
   */
  public static ImmutableAuthenticationConfig copyOf(AuthenticationConfig instance) {
    if (instance instanceof ImmutableAuthenticationConfig) {
      return (ImmutableAuthenticationConfig) instance;
    }
    return ImmutableAuthenticationConfig.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableAuthenticationConfig ImmutableAuthenticationConfig}.
   * @return A new ImmutableAuthenticationConfig builder
   */
  public static ImmutableAuthenticationConfig.Builder builder() {
    return new ImmutableAuthenticationConfig.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableAuthenticationConfig ImmutableAuthenticationConfig}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private @Nullable Boolean isBasicAuthSupported;
    private @Nullable Boolean isApiKeyAuthSupported;
    private @Nullable Boolean isOAuth2Supported;
    private @Nullable Boolean isCustomAuthSupported;
    private @Nullable OAuth2Defaults oAuth2Defaults;
    private ImmutableList.Builder<CustomAuthConfig> customAuthConfig = null;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code AuthenticationConfig} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(AuthenticationConfig instance) {
      Preconditions.checkNotNull(instance, "instance");
      @Nullable Boolean isBasicAuthSupportedValue = instance.isBasicAuthSupported();
      if (isBasicAuthSupportedValue != null) {
        isBasicAuthSupported(isBasicAuthSupportedValue);
      }
      @Nullable Boolean isApiKeyAuthSupportedValue = instance.isApiKeyAuthSupported();
      if (isApiKeyAuthSupportedValue != null) {
        isApiKeyAuthSupported(isApiKeyAuthSupportedValue);
      }
      @Nullable Boolean isOAuth2SupportedValue = instance.isOAuth2Supported();
      if (isOAuth2SupportedValue != null) {
        isOAuth2Supported(isOAuth2SupportedValue);
      }
      @Nullable Boolean isCustomAuthSupportedValue = instance.isCustomAuthSupported();
      if (isCustomAuthSupportedValue != null) {
        isCustomAuthSupported(isCustomAuthSupportedValue);
      }
      @Nullable OAuth2Defaults oAuth2DefaultsValue = instance.oAuth2Defaults();
      if (oAuth2DefaultsValue != null) {
        oAuth2Defaults(oAuth2DefaultsValue);
      }
      @Nullable List<CustomAuthConfig> customAuthConfigValue = instance.customAuthConfig();
      if (customAuthConfigValue != null) {
        addAllCustomAuthConfig(customAuthConfigValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link AuthenticationConfig#isBasicAuthSupported() isBasicAuthSupported} attribute.
     * @param isBasicAuthSupported The value for isBasicAuthSupported (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isBasicAuthSupported(@Nullable Boolean isBasicAuthSupported) {
      this.isBasicAuthSupported = isBasicAuthSupported;
      return this;
    }

    /**
     * Initializes the value for the {@link AuthenticationConfig#isApiKeyAuthSupported() isApiKeyAuthSupported} attribute.
     * @param isApiKeyAuthSupported The value for isApiKeyAuthSupported (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isApiKeyAuthSupported(@Nullable Boolean isApiKeyAuthSupported) {
      this.isApiKeyAuthSupported = isApiKeyAuthSupported;
      return this;
    }

    /**
     * Initializes the value for the {@link AuthenticationConfig#isOAuth2Supported() isOAuth2Supported} attribute.
     * @param isOAuth2Supported The value for isOAuth2Supported (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isOAuth2Supported(@Nullable Boolean isOAuth2Supported) {
      this.isOAuth2Supported = isOAuth2Supported;
      return this;
    }

    /**
     * Initializes the value for the {@link AuthenticationConfig#isCustomAuthSupported() isCustomAuthSupported} attribute.
     * @param isCustomAuthSupported The value for isCustomAuthSupported (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isCustomAuthSupported(@Nullable Boolean isCustomAuthSupported) {
      this.isCustomAuthSupported = isCustomAuthSupported;
      return this;
    }

    /**
     * Initializes the value for the {@link AuthenticationConfig#oAuth2Defaults() oAuth2Defaults} attribute.
     * @param oAuth2Defaults The value for oAuth2Defaults (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder oAuth2Defaults(@Nullable OAuth2Defaults oAuth2Defaults) {
      this.oAuth2Defaults = oAuth2Defaults;
      return this;
    }

    /**
     * Adds one element to {@link AuthenticationConfig#customAuthConfig() customAuthConfig} list.
     * @param element A customAuthConfig element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addCustomAuthConfig(CustomAuthConfig element) {
      if (this.customAuthConfig == null) {
        this.customAuthConfig = ImmutableList.builder();
      }
      this.customAuthConfig.add(element);
      return this;
    }

    /**
     * Adds elements to {@link AuthenticationConfig#customAuthConfig() customAuthConfig} list.
     * @param elements An array of customAuthConfig elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addCustomAuthConfig(CustomAuthConfig... elements) {
      if (this.customAuthConfig == null) {
        this.customAuthConfig = ImmutableList.builder();
      }
      this.customAuthConfig.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link AuthenticationConfig#customAuthConfig() customAuthConfig} list.
     * @param elements An iterable of customAuthConfig elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder customAuthConfig(@Nullable Iterable<? extends CustomAuthConfig> elements) {
      if (elements == null) {
        this.customAuthConfig = null;
        return this;
      }
      this.customAuthConfig = ImmutableList.builder();
      return addAllCustomAuthConfig(elements);
    }

    /**
     * Adds elements to {@link AuthenticationConfig#customAuthConfig() customAuthConfig} list.
     * @param elements An iterable of customAuthConfig elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllCustomAuthConfig(Iterable<? extends CustomAuthConfig> elements) {
      Preconditions.checkNotNull(elements, "customAuthConfig element");
      if (this.customAuthConfig == null) {
        this.customAuthConfig = ImmutableList.builder();
      }
      this.customAuthConfig.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutableAuthenticationConfig ImmutableAuthenticationConfig}.
     * @return An immutable instance of AuthenticationConfig
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableAuthenticationConfig build() {
      return new ImmutableAuthenticationConfig(
          isBasicAuthSupported,
          isApiKeyAuthSupported,
          isOAuth2Supported,
          isCustomAuthSupported,
          oAuth2Defaults,
          customAuthConfig == null ? null : customAuthConfig.build());
    }
  }
}
