package com.amazonaws.appflow.custom.connector.model.credentials;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link ApiKeyCredentials}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableApiKeyCredentials.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableApiKeyCredentials
    implements ApiKeyCredentials {
  private final String apiKey;
  private final @Nullable String secretKey;

  private ImmutableApiKeyCredentials(String apiKey, @Nullable String secretKey) {
    this.apiKey = apiKey;
    this.secretKey = secretKey;
  }

  /**
   * API key.
   */
  @JsonProperty("apiKey")
  @Override
  public String apiKey() {
    return apiKey;
  }

  /**
   * Secret key.
   */
  @JsonProperty("secretKey")
  @Override
  public @Nullable String secretKey() {
    return secretKey;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ApiKeyCredentials#apiKey() apiKey} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param apiKey A new value for apiKey
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableApiKeyCredentials withApiKey(String apiKey) {
    if (this.apiKey.equals(apiKey)) return this;
    String newValue = Preconditions.checkNotNull(apiKey, "apiKey");
    return new ImmutableApiKeyCredentials(newValue, this.secretKey);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ApiKeyCredentials#secretKey() secretKey} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param secretKey A new value for secretKey (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableApiKeyCredentials withSecretKey(@Nullable String secretKey) {
    if (Objects.equal(this.secretKey, secretKey)) return this;
    return new ImmutableApiKeyCredentials(this.apiKey, secretKey);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableApiKeyCredentials} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableApiKeyCredentials
        && equalTo((ImmutableApiKeyCredentials) another);
  }

  private boolean equalTo(ImmutableApiKeyCredentials another) {
    return apiKey.equals(another.apiKey)
        && Objects.equal(secretKey, another.secretKey);
  }

  /**
   * Computes a hash code from attributes: {@code apiKey}, {@code secretKey}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + apiKey.hashCode();
    h = h * 17 + Objects.hashCode(secretKey);
    return h;
  }

  /**
   * Prints the immutable value {@code ApiKeyCredentials} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ApiKeyCredentials")
        .omitNullValues()
        .add("apiKey", apiKey)
        .add("secretKey", secretKey)
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
      implements ApiKeyCredentials {
    @Nullable String apiKey;
    @Nullable String secretKey;
    @JsonProperty("apiKey")
    public void setApiKey(String apiKey) {
      this.apiKey = apiKey;
    }
    @JsonProperty("secretKey")
    public void setSecretKey(@Nullable String secretKey) {
      this.secretKey = secretKey;
    }
    @Override
    public String apiKey() { throw new UnsupportedOperationException(); }
    @Override
    public String secretKey() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableApiKeyCredentials fromJson(Json json) {
    ImmutableApiKeyCredentials.Builder builder = ImmutableApiKeyCredentials.builder();
    if (json.apiKey != null) {
      builder.apiKey(json.apiKey);
    }
    if (json.secretKey != null) {
      builder.secretKey(json.secretKey);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link ApiKeyCredentials} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ApiKeyCredentials instance
   */
  public static ImmutableApiKeyCredentials copyOf(ApiKeyCredentials instance) {
    if (instance instanceof ImmutableApiKeyCredentials) {
      return (ImmutableApiKeyCredentials) instance;
    }
    return ImmutableApiKeyCredentials.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableApiKeyCredentials ImmutableApiKeyCredentials}.
   * @return A new ImmutableApiKeyCredentials builder
   */
  public static ImmutableApiKeyCredentials.Builder builder() {
    return new ImmutableApiKeyCredentials.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableApiKeyCredentials ImmutableApiKeyCredentials}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_API_KEY = 0x1L;
    private long initBits = 0x1L;

    private @Nullable String apiKey;
    private @Nullable String secretKey;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ApiKeyCredentials} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ApiKeyCredentials instance) {
      Preconditions.checkNotNull(instance, "instance");
      apiKey(instance.apiKey());
      @Nullable String secretKeyValue = instance.secretKey();
      if (secretKeyValue != null) {
        secretKey(secretKeyValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link ApiKeyCredentials#apiKey() apiKey} attribute.
     * @param apiKey The value for apiKey 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder apiKey(String apiKey) {
      this.apiKey = Preconditions.checkNotNull(apiKey, "apiKey");
      initBits &= ~INIT_BIT_API_KEY;
      return this;
    }

    /**
     * Initializes the value for the {@link ApiKeyCredentials#secretKey() secretKey} attribute.
     * @param secretKey The value for secretKey (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder secretKey(@Nullable String secretKey) {
      this.secretKey = secretKey;
      return this;
    }

    /**
     * Builds a new {@link ImmutableApiKeyCredentials ImmutableApiKeyCredentials}.
     * @return An immutable instance of ApiKeyCredentials
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableApiKeyCredentials build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableApiKeyCredentials(apiKey, secretKey);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_API_KEY) != 0) attributes.add("apiKey");
      return "Cannot build ApiKeyCredentials, some of required attributes are not set " + attributes;
    }
  }
}
