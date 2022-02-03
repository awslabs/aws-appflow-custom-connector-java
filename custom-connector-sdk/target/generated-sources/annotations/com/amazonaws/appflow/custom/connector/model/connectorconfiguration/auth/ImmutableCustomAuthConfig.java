package com.amazonaws.appflow.custom.connector.model.connectorconfiguration.auth;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link CustomAuthConfig}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableCustomAuthConfig.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableCustomAuthConfig
    implements CustomAuthConfig {
  private final String authenticationType;
  private final ImmutableList<AuthParameter> authParameters;

  private ImmutableCustomAuthConfig(
      String authenticationType,
      ImmutableList<AuthParameter> authParameters) {
    this.authenticationType = authenticationType;
    this.authParameters = authParameters;
  }

  /**
   * AuthenticationType string value defined by Connector.
   */
  @JsonProperty("authenticationType")
  @Override
  public String authenticationType() {
    return authenticationType;
  }

  /**
   * List of Auth Parameters.
   */
  @JsonProperty("authParameters")
  @Override
  public ImmutableList<AuthParameter> authParameters() {
    return authParameters;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CustomAuthConfig#authenticationType() authenticationType} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param authenticationType A new value for authenticationType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCustomAuthConfig withAuthenticationType(String authenticationType) {
    if (this.authenticationType.equals(authenticationType)) return this;
    String newValue = Preconditions.checkNotNull(authenticationType, "authenticationType");
    return new ImmutableCustomAuthConfig(newValue, this.authParameters);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link CustomAuthConfig#authParameters() authParameters}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCustomAuthConfig withAuthParameters(AuthParameter... elements) {
    ImmutableList<AuthParameter> newValue = ImmutableList.copyOf(elements);
    return new ImmutableCustomAuthConfig(this.authenticationType, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link CustomAuthConfig#authParameters() authParameters}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of authParameters elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCustomAuthConfig withAuthParameters(Iterable<? extends AuthParameter> elements) {
    if (this.authParameters == elements) return this;
    ImmutableList<AuthParameter> newValue = ImmutableList.copyOf(elements);
    return new ImmutableCustomAuthConfig(this.authenticationType, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableCustomAuthConfig} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableCustomAuthConfig
        && equalTo((ImmutableCustomAuthConfig) another);
  }

  private boolean equalTo(ImmutableCustomAuthConfig another) {
    return authenticationType.equals(another.authenticationType)
        && authParameters.equals(another.authParameters);
  }

  /**
   * Computes a hash code from attributes: {@code authenticationType}, {@code authParameters}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + authenticationType.hashCode();
    h = h * 17 + authParameters.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code CustomAuthConfig} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("CustomAuthConfig")
        .omitNullValues()
        .add("authenticationType", authenticationType)
        .add("authParameters", authParameters)
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
      implements CustomAuthConfig {
    @Nullable String authenticationType;
    List<AuthParameter> authParameters = ImmutableList.of();
    @JsonProperty("authenticationType")
    public void setAuthenticationType(String authenticationType) {
      this.authenticationType = authenticationType;
    }
    @JsonProperty("authParameters")
    public void setAuthParameters(List<AuthParameter> authParameters) {
      this.authParameters = authParameters;
    }
    @Override
    public String authenticationType() { throw new UnsupportedOperationException(); }
    @Override
    public List<AuthParameter> authParameters() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableCustomAuthConfig fromJson(Json json) {
    ImmutableCustomAuthConfig.Builder builder = ImmutableCustomAuthConfig.builder();
    if (json.authenticationType != null) {
      builder.authenticationType(json.authenticationType);
    }
    if (json.authParameters != null) {
      builder.addAllAuthParameters(json.authParameters);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link CustomAuthConfig} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable CustomAuthConfig instance
   */
  public static ImmutableCustomAuthConfig copyOf(CustomAuthConfig instance) {
    if (instance instanceof ImmutableCustomAuthConfig) {
      return (ImmutableCustomAuthConfig) instance;
    }
    return ImmutableCustomAuthConfig.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableCustomAuthConfig ImmutableCustomAuthConfig}.
   * @return A new ImmutableCustomAuthConfig builder
   */
  public static ImmutableCustomAuthConfig.Builder builder() {
    return new ImmutableCustomAuthConfig.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableCustomAuthConfig ImmutableCustomAuthConfig}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_AUTHENTICATION_TYPE = 0x1L;
    private long initBits = 0x1L;

    private @Nullable String authenticationType;
    private ImmutableList.Builder<AuthParameter> authParameters = ImmutableList.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code CustomAuthConfig} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(CustomAuthConfig instance) {
      Preconditions.checkNotNull(instance, "instance");
      authenticationType(instance.authenticationType());
      addAllAuthParameters(instance.authParameters());
      return this;
    }

    /**
     * Initializes the value for the {@link CustomAuthConfig#authenticationType() authenticationType} attribute.
     * @param authenticationType The value for authenticationType 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder authenticationType(String authenticationType) {
      this.authenticationType = Preconditions.checkNotNull(authenticationType, "authenticationType");
      initBits &= ~INIT_BIT_AUTHENTICATION_TYPE;
      return this;
    }

    /**
     * Adds one element to {@link CustomAuthConfig#authParameters() authParameters} list.
     * @param element A authParameters element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAuthParameters(AuthParameter element) {
      this.authParameters.add(element);
      return this;
    }

    /**
     * Adds elements to {@link CustomAuthConfig#authParameters() authParameters} list.
     * @param elements An array of authParameters elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAuthParameters(AuthParameter... elements) {
      this.authParameters.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link CustomAuthConfig#authParameters() authParameters} list.
     * @param elements An iterable of authParameters elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder authParameters(Iterable<? extends AuthParameter> elements) {
      this.authParameters = ImmutableList.builder();
      return addAllAuthParameters(elements);
    }

    /**
     * Adds elements to {@link CustomAuthConfig#authParameters() authParameters} list.
     * @param elements An iterable of authParameters elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllAuthParameters(Iterable<? extends AuthParameter> elements) {
      this.authParameters.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutableCustomAuthConfig ImmutableCustomAuthConfig}.
     * @return An immutable instance of CustomAuthConfig
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableCustomAuthConfig build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableCustomAuthConfig(authenticationType, authParameters.build());
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_AUTHENTICATION_TYPE) != 0) attributes.add("authenticationType");
      return "Cannot build CustomAuthConfig, some of required attributes are not set " + attributes;
    }
  }
}
