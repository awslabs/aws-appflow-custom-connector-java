package com.amzonaws.appflow.custom.connector.integ.providers;

import com.amazonaws.appflow.custom.connector.model.credentials.Credentials;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Optional;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link TestCredentials}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableTestCredentials.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableTestCredentials
    implements TestCredentials {
  private final @Nullable Credentials credentials;
  private final @Nullable String clientId;
  private final @Nullable String clientSecret;

  private ImmutableTestCredentials(
      @Nullable Credentials credentials,
      @Nullable String clientId,
      @Nullable String clientSecret) {
    this.credentials = credentials;
    this.clientId = clientId;
    this.clientSecret = clientSecret;
  }

  /**
   * @return The value of the {@code credentials} attribute
   */
  @JsonProperty("credentials")
  @Override
  public Optional<Credentials> credentials() {
    return Optional.ofNullable(credentials);
  }

  /**
   * @return The value of the {@code clientId} attribute
   */
  @JsonProperty("clientId")
  @Override
  public Optional<String> clientId() {
    return Optional.ofNullable(clientId);
  }

  /**
   * @return The value of the {@code clientSecret} attribute
   */
  @JsonProperty("clientSecret")
  @Override
  public Optional<String> clientSecret() {
    return Optional.ofNullable(clientSecret);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link TestCredentials#credentials() credentials} attribute.
   * @param value The value for credentials
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTestCredentials withCredentials(Credentials value) {
    @Nullable Credentials newValue = Preconditions.checkNotNull(value, "credentials");
    if (this.credentials == newValue) return this;
    return new ImmutableTestCredentials(newValue, this.clientId, this.clientSecret);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link TestCredentials#credentials() credentials} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for credentials
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTestCredentials withCredentials(Optional<Credentials> optional) {
    @Nullable Credentials value = optional.orElse(null);
    if (this.credentials == value) return this;
    return new ImmutableTestCredentials(value, this.clientId, this.clientSecret);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link TestCredentials#clientId() clientId} attribute.
   * @param value The value for clientId
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTestCredentials withClientId(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "clientId");
    if (Objects.equal(this.clientId, newValue)) return this;
    return new ImmutableTestCredentials(this.credentials, newValue, this.clientSecret);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link TestCredentials#clientId() clientId} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for clientId
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTestCredentials withClientId(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.clientId, value)) return this;
    return new ImmutableTestCredentials(this.credentials, value, this.clientSecret);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link TestCredentials#clientSecret() clientSecret} attribute.
   * @param value The value for clientSecret
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTestCredentials withClientSecret(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "clientSecret");
    if (Objects.equal(this.clientSecret, newValue)) return this;
    return new ImmutableTestCredentials(this.credentials, this.clientId, newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link TestCredentials#clientSecret() clientSecret} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for clientSecret
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTestCredentials withClientSecret(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.clientSecret, value)) return this;
    return new ImmutableTestCredentials(this.credentials, this.clientId, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableTestCredentials} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableTestCredentials
        && equalTo((ImmutableTestCredentials) another);
  }

  private boolean equalTo(ImmutableTestCredentials another) {
    return Objects.equal(credentials, another.credentials)
        && Objects.equal(clientId, another.clientId)
        && Objects.equal(clientSecret, another.clientSecret);
  }

  /**
   * Computes a hash code from attributes: {@code credentials}, {@code clientId}, {@code clientSecret}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Objects.hashCode(credentials);
    h = h * 17 + Objects.hashCode(clientId);
    h = h * 17 + Objects.hashCode(clientSecret);
    return h;
  }

  /**
   * Prints the immutable value {@code TestCredentials} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("TestCredentials")
        .omitNullValues()
        .add("credentials", credentials)
        .add("clientId", clientId)
        .add("clientSecret", clientSecret)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements TestCredentials {
    Optional<Credentials> credentials = Optional.empty();
    Optional<String> clientId = Optional.empty();
    Optional<String> clientSecret = Optional.empty();
    @JsonProperty("credentials")
    public void setCredentials(Optional<Credentials> credentials) {
      this.credentials = credentials;
    }
    @JsonProperty("clientId")
    public void setClientId(Optional<String> clientId) {
      this.clientId = clientId;
    }
    @JsonProperty("clientSecret")
    public void setClientSecret(Optional<String> clientSecret) {
      this.clientSecret = clientSecret;
    }
    @Override
    public Optional<Credentials> credentials() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> clientId() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> clientSecret() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableTestCredentials fromJson(Json json) {
    ImmutableTestCredentials.Builder builder = ImmutableTestCredentials.builder();
    if (json.credentials != null) {
      builder.credentials(json.credentials);
    }
    if (json.clientId != null) {
      builder.clientId(json.clientId);
    }
    if (json.clientSecret != null) {
      builder.clientSecret(json.clientSecret);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link TestCredentials} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable TestCredentials instance
   */
  public static ImmutableTestCredentials copyOf(TestCredentials instance) {
    if (instance instanceof ImmutableTestCredentials) {
      return (ImmutableTestCredentials) instance;
    }
    return ImmutableTestCredentials.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableTestCredentials ImmutableTestCredentials}.
   * @return A new ImmutableTestCredentials builder
   */
  public static ImmutableTestCredentials.Builder builder() {
    return new ImmutableTestCredentials.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableTestCredentials ImmutableTestCredentials}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private @Nullable Credentials credentials;
    private @Nullable String clientId;
    private @Nullable String clientSecret;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code TestCredentials} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(TestCredentials instance) {
      Preconditions.checkNotNull(instance, "instance");
      Optional<Credentials> credentialsOptional = instance.credentials();
      if (credentialsOptional.isPresent()) {
        credentials(credentialsOptional);
      }
      Optional<String> clientIdOptional = instance.clientId();
      if (clientIdOptional.isPresent()) {
        clientId(clientIdOptional);
      }
      Optional<String> clientSecretOptional = instance.clientSecret();
      if (clientSecretOptional.isPresent()) {
        clientSecret(clientSecretOptional);
      }
      return this;
    }

    /**
     * Initializes the optional value {@link TestCredentials#credentials() credentials} to credentials.
     * @param credentials The value for credentials
     * @return {@code this} builder for chained invocation
     */
    public final Builder credentials(Credentials credentials) {
      this.credentials = Preconditions.checkNotNull(credentials, "credentials");
      return this;
    }

    /**
     * Initializes the optional value {@link TestCredentials#credentials() credentials} to credentials.
     * @param credentials The value for credentials
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder credentials(Optional<Credentials> credentials) {
      this.credentials = credentials.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link TestCredentials#clientId() clientId} to clientId.
     * @param clientId The value for clientId
     * @return {@code this} builder for chained invocation
     */
    public final Builder clientId(String clientId) {
      this.clientId = Preconditions.checkNotNull(clientId, "clientId");
      return this;
    }

    /**
     * Initializes the optional value {@link TestCredentials#clientId() clientId} to clientId.
     * @param clientId The value for clientId
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder clientId(Optional<String> clientId) {
      this.clientId = clientId.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link TestCredentials#clientSecret() clientSecret} to clientSecret.
     * @param clientSecret The value for clientSecret
     * @return {@code this} builder for chained invocation
     */
    public final Builder clientSecret(String clientSecret) {
      this.clientSecret = Preconditions.checkNotNull(clientSecret, "clientSecret");
      return this;
    }

    /**
     * Initializes the optional value {@link TestCredentials#clientSecret() clientSecret} to clientSecret.
     * @param clientSecret The value for clientSecret
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder clientSecret(Optional<String> clientSecret) {
      this.clientSecret = clientSecret.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ImmutableTestCredentials ImmutableTestCredentials}.
     * @return An immutable instance of TestCredentials
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableTestCredentials build() {
      return new ImmutableTestCredentials(credentials, clientId, clientSecret);
    }
  }
}
