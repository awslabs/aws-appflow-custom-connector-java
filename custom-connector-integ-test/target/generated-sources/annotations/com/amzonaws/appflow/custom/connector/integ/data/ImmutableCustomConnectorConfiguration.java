package com.amzonaws.appflow.custom.connector.integ.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link CustomConnectorConfiguration}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableCustomConnectorConfiguration.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableCustomConnectorConfiguration
    implements CustomConnectorConfiguration {
  private final String lambdaArn;
  private final String name;
  private final @Nullable String validationFileName;

  private ImmutableCustomConnectorConfiguration(
      String lambdaArn,
      String name,
      @Nullable String validationFileName) {
    this.lambdaArn = lambdaArn;
    this.name = name;
    this.validationFileName = validationFileName;
  }

  /**
   * @return The value of the {@code lambdaArn} attribute
   */
  @JsonProperty("lambdaArn")
  @Override
  public String lambdaArn() {
    return lambdaArn;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @JsonProperty("name")
  @Override
  public String name() {
    return name;
  }

  /**
   * @return The value of the {@code validationFileName} attribute
   */
  @JsonProperty("validationFileName")
  @Override
  public Optional<String> validationFileName() {
    return Optional.ofNullable(validationFileName);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CustomConnectorConfiguration#lambdaArn() lambdaArn} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param lambdaArn A new value for lambdaArn
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCustomConnectorConfiguration withLambdaArn(String lambdaArn) {
    if (this.lambdaArn.equals(lambdaArn)) return this;
    String newValue = Preconditions.checkNotNull(lambdaArn, "lambdaArn");
    return new ImmutableCustomConnectorConfiguration(newValue, this.name, this.validationFileName);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CustomConnectorConfiguration#name() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param name A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCustomConnectorConfiguration withName(String name) {
    if (this.name.equals(name)) return this;
    String newValue = Preconditions.checkNotNull(name, "name");
    return new ImmutableCustomConnectorConfiguration(this.lambdaArn, newValue, this.validationFileName);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link CustomConnectorConfiguration#validationFileName() validationFileName} attribute.
   * @param value The value for validationFileName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCustomConnectorConfiguration withValidationFileName(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "validationFileName");
    if (Objects.equal(this.validationFileName, newValue)) return this;
    return new ImmutableCustomConnectorConfiguration(this.lambdaArn, this.name, newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link CustomConnectorConfiguration#validationFileName() validationFileName} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for validationFileName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCustomConnectorConfiguration withValidationFileName(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.validationFileName, value)) return this;
    return new ImmutableCustomConnectorConfiguration(this.lambdaArn, this.name, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableCustomConnectorConfiguration} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableCustomConnectorConfiguration
        && equalTo((ImmutableCustomConnectorConfiguration) another);
  }

  private boolean equalTo(ImmutableCustomConnectorConfiguration another) {
    return lambdaArn.equals(another.lambdaArn)
        && name.equals(another.name)
        && Objects.equal(validationFileName, another.validationFileName);
  }

  /**
   * Computes a hash code from attributes: {@code lambdaArn}, {@code name}, {@code validationFileName}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + lambdaArn.hashCode();
    h = h * 17 + name.hashCode();
    h = h * 17 + Objects.hashCode(validationFileName);
    return h;
  }

  /**
   * Prints the immutable value {@code CustomConnectorConfiguration} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("CustomConnectorConfiguration")
        .omitNullValues()
        .add("lambdaArn", lambdaArn)
        .add("name", name)
        .add("validationFileName", validationFileName)
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
      implements CustomConnectorConfiguration {
    @Nullable String lambdaArn;
    @Nullable String name;
    Optional<String> validationFileName = Optional.empty();
    @JsonProperty("lambdaArn")
    public void setLambdaArn(String lambdaArn) {
      this.lambdaArn = lambdaArn;
    }
    @JsonProperty("name")
    public void setName(String name) {
      this.name = name;
    }
    @JsonProperty("validationFileName")
    public void setValidationFileName(Optional<String> validationFileName) {
      this.validationFileName = validationFileName;
    }
    @Override
    public String lambdaArn() { throw new UnsupportedOperationException(); }
    @Override
    public String name() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> validationFileName() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableCustomConnectorConfiguration fromJson(Json json) {
    ImmutableCustomConnectorConfiguration.Builder builder = ImmutableCustomConnectorConfiguration.builder();
    if (json.lambdaArn != null) {
      builder.lambdaArn(json.lambdaArn);
    }
    if (json.name != null) {
      builder.name(json.name);
    }
    if (json.validationFileName != null) {
      builder.validationFileName(json.validationFileName);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link CustomConnectorConfiguration} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable CustomConnectorConfiguration instance
   */
  public static ImmutableCustomConnectorConfiguration copyOf(CustomConnectorConfiguration instance) {
    if (instance instanceof ImmutableCustomConnectorConfiguration) {
      return (ImmutableCustomConnectorConfiguration) instance;
    }
    return ImmutableCustomConnectorConfiguration.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableCustomConnectorConfiguration ImmutableCustomConnectorConfiguration}.
   * @return A new ImmutableCustomConnectorConfiguration builder
   */
  public static ImmutableCustomConnectorConfiguration.Builder builder() {
    return new ImmutableCustomConnectorConfiguration.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableCustomConnectorConfiguration ImmutableCustomConnectorConfiguration}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_LAMBDA_ARN = 0x1L;
    private static final long INIT_BIT_NAME = 0x2L;
    private long initBits = 0x3L;

    private @Nullable String lambdaArn;
    private @Nullable String name;
    private @Nullable String validationFileName;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code CustomConnectorConfiguration} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(CustomConnectorConfiguration instance) {
      Preconditions.checkNotNull(instance, "instance");
      lambdaArn(instance.lambdaArn());
      name(instance.name());
      Optional<String> validationFileNameOptional = instance.validationFileName();
      if (validationFileNameOptional.isPresent()) {
        validationFileName(validationFileNameOptional);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link CustomConnectorConfiguration#lambdaArn() lambdaArn} attribute.
     * @param lambdaArn The value for lambdaArn 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder lambdaArn(String lambdaArn) {
      this.lambdaArn = Preconditions.checkNotNull(lambdaArn, "lambdaArn");
      initBits &= ~INIT_BIT_LAMBDA_ARN;
      return this;
    }

    /**
     * Initializes the value for the {@link CustomConnectorConfiguration#name() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder name(String name) {
      this.name = Preconditions.checkNotNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Initializes the optional value {@link CustomConnectorConfiguration#validationFileName() validationFileName} to validationFileName.
     * @param validationFileName The value for validationFileName
     * @return {@code this} builder for chained invocation
     */
    public final Builder validationFileName(String validationFileName) {
      this.validationFileName = Preconditions.checkNotNull(validationFileName, "validationFileName");
      return this;
    }

    /**
     * Initializes the optional value {@link CustomConnectorConfiguration#validationFileName() validationFileName} to validationFileName.
     * @param validationFileName The value for validationFileName
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder validationFileName(Optional<String> validationFileName) {
      this.validationFileName = validationFileName.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ImmutableCustomConnectorConfiguration ImmutableCustomConnectorConfiguration}.
     * @return An immutable instance of CustomConnectorConfiguration
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableCustomConnectorConfiguration build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableCustomConnectorConfiguration(lambdaArn, name, validationFileName);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_LAMBDA_ARN) != 0) attributes.add("lambdaArn");
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      return "Cannot build CustomConnectorConfiguration, some of required attributes are not set " + attributes;
    }
  }
}
