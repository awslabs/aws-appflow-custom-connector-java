package com.amazonaws.appflow.custom.connector.model.credentials;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link Credentials}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableCredentials.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableCredentials
    implements Credentials {
  private final @Nullable String secretArn;
  private final @Nullable AuthenticationType authenticationType;

  private ImmutableCredentials(
      @Nullable String secretArn,
      @Nullable AuthenticationType authenticationType) {
    this.secretArn = secretArn;
    this.authenticationType = authenticationType;
  }

  /**
   * ARN of the secret (authentication credentials) stored in AWS Secret Manager.
   */
  @JsonProperty("secretArn")
  @Override
  public @Nullable String secretArn() {
    return secretArn;
  }

  /**
   * Authentication type associated with the credentials stored in AWS Secret Manager.
   */
  @JsonProperty("authenticationType")
  @Override
  public @Nullable AuthenticationType authenticationType() {
    return authenticationType;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Credentials#secretArn() secretArn} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param secretArn A new value for secretArn (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCredentials withSecretArn(@Nullable String secretArn) {
    if (Objects.equal(this.secretArn, secretArn)) return this;
    return new ImmutableCredentials(secretArn, this.authenticationType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Credentials#authenticationType() authenticationType} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param authenticationType A new value for authenticationType (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCredentials withAuthenticationType(@Nullable AuthenticationType authenticationType) {
    if (this.authenticationType == authenticationType) return this;
    return new ImmutableCredentials(this.secretArn, authenticationType);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableCredentials} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableCredentials
        && equalTo((ImmutableCredentials) another);
  }

  private boolean equalTo(ImmutableCredentials another) {
    return Objects.equal(secretArn, another.secretArn)
        && Objects.equal(authenticationType, another.authenticationType);
  }

  /**
   * Computes a hash code from attributes: {@code secretArn}, {@code authenticationType}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Objects.hashCode(secretArn);
    h = h * 17 + Objects.hashCode(authenticationType);
    return h;
  }

  /**
   * Prints the immutable value {@code Credentials} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Credentials")
        .omitNullValues()
        .add("secretArn", secretArn)
        .add("authenticationType", authenticationType)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements Credentials {
    @Nullable String secretArn;
    @Nullable AuthenticationType authenticationType;
    @JsonProperty("secretArn")
    public void setSecretArn(@Nullable String secretArn) {
      this.secretArn = secretArn;
    }
    @JsonProperty("authenticationType")
    public void setAuthenticationType(@Nullable AuthenticationType authenticationType) {
      this.authenticationType = authenticationType;
    }
    @Override
    public String secretArn() { throw new UnsupportedOperationException(); }
    @Override
    public AuthenticationType authenticationType() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableCredentials fromJson(Json json) {
    ImmutableCredentials.Builder builder = ImmutableCredentials.builder();
    if (json.secretArn != null) {
      builder.secretArn(json.secretArn);
    }
    if (json.authenticationType != null) {
      builder.authenticationType(json.authenticationType);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link Credentials} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Credentials instance
   */
  public static ImmutableCredentials copyOf(Credentials instance) {
    if (instance instanceof ImmutableCredentials) {
      return (ImmutableCredentials) instance;
    }
    return ImmutableCredentials.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableCredentials ImmutableCredentials}.
   * @return A new ImmutableCredentials builder
   */
  public static ImmutableCredentials.Builder builder() {
    return new ImmutableCredentials.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableCredentials ImmutableCredentials}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private @Nullable String secretArn;
    private @Nullable AuthenticationType authenticationType;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Credentials} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Credentials instance) {
      Preconditions.checkNotNull(instance, "instance");
      @Nullable String secretArnValue = instance.secretArn();
      if (secretArnValue != null) {
        secretArn(secretArnValue);
      }
      @Nullable AuthenticationType authenticationTypeValue = instance.authenticationType();
      if (authenticationTypeValue != null) {
        authenticationType(authenticationTypeValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link Credentials#secretArn() secretArn} attribute.
     * @param secretArn The value for secretArn (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder secretArn(@Nullable String secretArn) {
      this.secretArn = secretArn;
      return this;
    }

    /**
     * Initializes the value for the {@link Credentials#authenticationType() authenticationType} attribute.
     * @param authenticationType The value for authenticationType (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder authenticationType(@Nullable AuthenticationType authenticationType) {
      this.authenticationType = authenticationType;
      return this;
    }

    /**
     * Builds a new {@link ImmutableCredentials ImmutableCredentials}.
     * @return An immutable instance of Credentials
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableCredentials build() {
      return new ImmutableCredentials(secretArn, authenticationType);
    }
  }
}
