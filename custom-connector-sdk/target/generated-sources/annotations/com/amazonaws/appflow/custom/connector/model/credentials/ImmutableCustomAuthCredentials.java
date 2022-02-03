package com.amazonaws.appflow.custom.connector.model.credentials;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link CustomAuthCredentials}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableCustomAuthCredentials.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableCustomAuthCredentials
    implements CustomAuthCredentials {
  private final String customAuthenticationType;
  private final String authenticationType;
  private final ImmutableMap<String, String> customCredentials;

  private ImmutableCustomAuthCredentials(
      String customAuthenticationType,
      String authenticationType,
      ImmutableMap<String, String> customCredentials) {
    this.customAuthenticationType = customAuthenticationType;
    this.authenticationType = authenticationType;
    this.customCredentials = customCredentials;
  }

  /**
   * Authentication Type defined by Connector.
   */
  @JsonProperty("customAuthenticationType")
  @Override
  public String customAuthenticationType() {
    return customAuthenticationType;
  }

  /**
   * [Deprecated: Added for backward compatiblity]Authentication Type defined by Connector.
   */
  @JsonProperty("authenticationType")
  @Override
  public String authenticationType() {
    return authenticationType;
  }

  /**
   * Custom Credentials provided by connector user. Key will be <code>AuthParameter.key()</code> and value will be the
   * input provided by user.
   */
  @JsonProperty("customCredentials")
  @Override
  public ImmutableMap<String, String> customCredentials() {
    return customCredentials;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CustomAuthCredentials#customAuthenticationType() customAuthenticationType} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param customAuthenticationType A new value for customAuthenticationType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCustomAuthCredentials withCustomAuthenticationType(String customAuthenticationType) {
    if (this.customAuthenticationType.equals(customAuthenticationType)) return this;
    String newValue = Preconditions.checkNotNull(customAuthenticationType, "customAuthenticationType");
    return new ImmutableCustomAuthCredentials(newValue, this.authenticationType, this.customCredentials);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CustomAuthCredentials#authenticationType() authenticationType} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param authenticationType A new value for authenticationType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCustomAuthCredentials withAuthenticationType(String authenticationType) {
    if (this.authenticationType.equals(authenticationType)) return this;
    String newValue = Preconditions.checkNotNull(authenticationType, "authenticationType");
    return new ImmutableCustomAuthCredentials(this.customAuthenticationType, newValue, this.customCredentials);
  }

  /**
   * Copy the current immutable object by replacing the {@link CustomAuthCredentials#customCredentials() customCredentials} map with the specified map.
   * Nulls are not permitted as keys or values.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param customCredentials The entries to be added to the customCredentials map
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCustomAuthCredentials withCustomCredentials(Map<String, ? extends String> customCredentials) {
    if (this.customCredentials == customCredentials) return this;
    ImmutableMap<String, String> newValue = ImmutableMap.copyOf(customCredentials);
    return new ImmutableCustomAuthCredentials(this.customAuthenticationType, this.authenticationType, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableCustomAuthCredentials} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableCustomAuthCredentials
        && equalTo((ImmutableCustomAuthCredentials) another);
  }

  private boolean equalTo(ImmutableCustomAuthCredentials another) {
    return customAuthenticationType.equals(another.customAuthenticationType)
        && authenticationType.equals(another.authenticationType)
        && customCredentials.equals(another.customCredentials);
  }

  /**
   * Computes a hash code from attributes: {@code customAuthenticationType}, {@code authenticationType}, {@code customCredentials}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + customAuthenticationType.hashCode();
    h = h * 17 + authenticationType.hashCode();
    h = h * 17 + customCredentials.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code CustomAuthCredentials} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("CustomAuthCredentials")
        .omitNullValues()
        .add("customAuthenticationType", customAuthenticationType)
        .add("authenticationType", authenticationType)
        .add("customCredentials", customCredentials)
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
      implements CustomAuthCredentials {
    @Nullable String customAuthenticationType;
    @Nullable String authenticationType;
    @Nullable Map<String, String> customCredentials;
    @JsonProperty("customAuthenticationType")
    public void setCustomAuthenticationType(String customAuthenticationType) {
      this.customAuthenticationType = customAuthenticationType;
    }
    @JsonProperty("authenticationType")
    public void setAuthenticationType(String authenticationType) {
      this.authenticationType = authenticationType;
    }
    @JsonProperty("customCredentials")
    public void setCustomCredentials(Map<String, String> customCredentials) {
      this.customCredentials = customCredentials;
    }
    @Override
    public String customAuthenticationType() { throw new UnsupportedOperationException(); }
    @Override
    public String authenticationType() { throw new UnsupportedOperationException(); }
    @Override
    public Map<String, String> customCredentials() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableCustomAuthCredentials fromJson(Json json) {
    ImmutableCustomAuthCredentials.Builder builder = ImmutableCustomAuthCredentials.builder();
    if (json.customAuthenticationType != null) {
      builder.customAuthenticationType(json.customAuthenticationType);
    }
    if (json.authenticationType != null) {
      builder.authenticationType(json.authenticationType);
    }
    if (json.customCredentials != null) {
      builder.putAllCustomCredentials(json.customCredentials);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link CustomAuthCredentials} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable CustomAuthCredentials instance
   */
  public static ImmutableCustomAuthCredentials copyOf(CustomAuthCredentials instance) {
    if (instance instanceof ImmutableCustomAuthCredentials) {
      return (ImmutableCustomAuthCredentials) instance;
    }
    return ImmutableCustomAuthCredentials.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableCustomAuthCredentials ImmutableCustomAuthCredentials}.
   * @return A new ImmutableCustomAuthCredentials builder
   */
  public static ImmutableCustomAuthCredentials.Builder builder() {
    return new ImmutableCustomAuthCredentials.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableCustomAuthCredentials ImmutableCustomAuthCredentials}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_CUSTOM_AUTHENTICATION_TYPE = 0x1L;
    private static final long INIT_BIT_AUTHENTICATION_TYPE = 0x2L;
    private long initBits = 0x3L;

    private @Nullable String customAuthenticationType;
    private @Nullable String authenticationType;
    private ImmutableMap.Builder<String, String> customCredentials = ImmutableMap.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code CustomAuthCredentials} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(CustomAuthCredentials instance) {
      Preconditions.checkNotNull(instance, "instance");
      customAuthenticationType(instance.customAuthenticationType());
      authenticationType(instance.authenticationType());
      putAllCustomCredentials(instance.customCredentials());
      return this;
    }

    /**
     * Initializes the value for the {@link CustomAuthCredentials#customAuthenticationType() customAuthenticationType} attribute.
     * @param customAuthenticationType The value for customAuthenticationType 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder customAuthenticationType(String customAuthenticationType) {
      this.customAuthenticationType = Preconditions.checkNotNull(customAuthenticationType, "customAuthenticationType");
      initBits &= ~INIT_BIT_CUSTOM_AUTHENTICATION_TYPE;
      return this;
    }

    /**
     * Initializes the value for the {@link CustomAuthCredentials#authenticationType() authenticationType} attribute.
     * @param authenticationType The value for authenticationType 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder authenticationType(String authenticationType) {
      this.authenticationType = Preconditions.checkNotNull(authenticationType, "authenticationType");
      initBits &= ~INIT_BIT_AUTHENTICATION_TYPE;
      return this;
    }

    /**
     * Put one entry to the {@link CustomAuthCredentials#customCredentials() customCredentials} map.
     * @param key The key in the customCredentials map
     * @param value The associated value in the customCredentials map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putCustomCredentials(String key, String value) {
      this.customCredentials.put(key, value);
      return this;
    }

    /**
     * Put one entry to the {@link CustomAuthCredentials#customCredentials() customCredentials} map. Nulls are not permitted
     * @param entry The key and value entry
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putCustomCredentials(Map.Entry<String, ? extends String> entry) {
      this.customCredentials.put(entry);
      return this;
    }

    /**
     * Sets or replaces all mappings from the specified map as entries for the {@link CustomAuthCredentials#customCredentials() customCredentials} map. Nulls are not permitted
     * @param customCredentials The entries that will be added to the customCredentials map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder customCredentials(Map<String, ? extends String> customCredentials) {
      this.customCredentials = ImmutableMap.builder();
      return putAllCustomCredentials(customCredentials);
    }

    /**
     * Put all mappings from the specified map as entries to {@link CustomAuthCredentials#customCredentials() customCredentials} map. Nulls are not permitted
     * @param customCredentials The entries that will be added to the customCredentials map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putAllCustomCredentials(Map<String, ? extends String> customCredentials) {
      this.customCredentials.putAll(customCredentials);
      return this;
    }

    /**
     * Builds a new {@link ImmutableCustomAuthCredentials ImmutableCustomAuthCredentials}.
     * @return An immutable instance of CustomAuthCredentials
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableCustomAuthCredentials build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableCustomAuthCredentials(customAuthenticationType, authenticationType, customCredentials.build());
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_CUSTOM_AUTHENTICATION_TYPE) != 0) attributes.add("customAuthenticationType");
      if ((initBits & INIT_BIT_AUTHENTICATION_TYPE) != 0) attributes.add("authenticationType");
      return "Cannot build CustomAuthCredentials, some of required attributes are not set " + attributes;
    }
  }
}
