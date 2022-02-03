package com.amzonaws.appflow.custom.connector.integ.data;

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
 * Immutable implementation of {@link ListConnectorEntitiesTestConfiguration}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableListConnectorEntitiesTestConfiguration.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableListConnectorEntitiesTestConfiguration
    implements ListConnectorEntitiesTestConfiguration {
  private final @Nullable String entitiesPath;
  private final @Nullable String validationFileName;
  private final @Nullable String profileName;
  private final @Nullable String testName;
  private final @Nullable String apiVersion;

  private ImmutableListConnectorEntitiesTestConfiguration(
      @Nullable String entitiesPath,
      @Nullable String validationFileName,
      @Nullable String profileName,
      @Nullable String testName,
      @Nullable String apiVersion) {
    this.entitiesPath = entitiesPath;
    this.validationFileName = validationFileName;
    this.profileName = profileName;
    this.testName = testName;
    this.apiVersion = apiVersion;
  }

  /**
   * @return The value of the {@code entitiesPath} attribute
   */
  @JsonProperty("entitiesPath")
  @Override
  public Optional<String> entitiesPath() {
    return Optional.ofNullable(entitiesPath);
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
   * @return The value of the {@code profileName} attribute
   */
  @JsonProperty("profileName")
  @Override
  public Optional<String> profileName() {
    return Optional.ofNullable(profileName);
  }

  /**
   * @return The value of the {@code testName} attribute
   */
  @JsonProperty("testName")
  @Override
  public Optional<String> testName() {
    return Optional.ofNullable(testName);
  }

  /**
   * @return The value of the {@code apiVersion} attribute
   */
  @JsonProperty("apiVersion")
  @Override
  public Optional<String> apiVersion() {
    return Optional.ofNullable(apiVersion);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link ListConnectorEntitiesTestConfiguration#entitiesPath() entitiesPath} attribute.
   * @param value The value for entitiesPath
   * @return A modified copy of {@code this} object
   */
  public final ImmutableListConnectorEntitiesTestConfiguration withEntitiesPath(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "entitiesPath");
    if (Objects.equal(this.entitiesPath, newValue)) return this;
    return new ImmutableListConnectorEntitiesTestConfiguration(newValue, this.validationFileName, this.profileName, this.testName, this.apiVersion);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link ListConnectorEntitiesTestConfiguration#entitiesPath() entitiesPath} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for entitiesPath
   * @return A modified copy of {@code this} object
   */
  public final ImmutableListConnectorEntitiesTestConfiguration withEntitiesPath(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.entitiesPath, value)) return this;
    return new ImmutableListConnectorEntitiesTestConfiguration(value, this.validationFileName, this.profileName, this.testName, this.apiVersion);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link ListConnectorEntitiesTestConfiguration#validationFileName() validationFileName} attribute.
   * @param value The value for validationFileName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableListConnectorEntitiesTestConfiguration withValidationFileName(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "validationFileName");
    if (Objects.equal(this.validationFileName, newValue)) return this;
    return new ImmutableListConnectorEntitiesTestConfiguration(this.entitiesPath, newValue, this.profileName, this.testName, this.apiVersion);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link ListConnectorEntitiesTestConfiguration#validationFileName() validationFileName} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for validationFileName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableListConnectorEntitiesTestConfiguration withValidationFileName(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.validationFileName, value)) return this;
    return new ImmutableListConnectorEntitiesTestConfiguration(this.entitiesPath, value, this.profileName, this.testName, this.apiVersion);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link ListConnectorEntitiesTestConfiguration#profileName() profileName} attribute.
   * @param value The value for profileName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableListConnectorEntitiesTestConfiguration withProfileName(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "profileName");
    if (Objects.equal(this.profileName, newValue)) return this;
    return new ImmutableListConnectorEntitiesTestConfiguration(this.entitiesPath, this.validationFileName, newValue, this.testName, this.apiVersion);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link ListConnectorEntitiesTestConfiguration#profileName() profileName} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for profileName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableListConnectorEntitiesTestConfiguration withProfileName(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.profileName, value)) return this;
    return new ImmutableListConnectorEntitiesTestConfiguration(this.entitiesPath, this.validationFileName, value, this.testName, this.apiVersion);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link ListConnectorEntitiesTestConfiguration#testName() testName} attribute.
   * @param value The value for testName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableListConnectorEntitiesTestConfiguration withTestName(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "testName");
    if (Objects.equal(this.testName, newValue)) return this;
    return new ImmutableListConnectorEntitiesTestConfiguration(this.entitiesPath, this.validationFileName, this.profileName, newValue, this.apiVersion);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link ListConnectorEntitiesTestConfiguration#testName() testName} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for testName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableListConnectorEntitiesTestConfiguration withTestName(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.testName, value)) return this;
    return new ImmutableListConnectorEntitiesTestConfiguration(this.entitiesPath, this.validationFileName, this.profileName, value, this.apiVersion);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link ListConnectorEntitiesTestConfiguration#apiVersion() apiVersion} attribute.
   * @param value The value for apiVersion
   * @return A modified copy of {@code this} object
   */
  public final ImmutableListConnectorEntitiesTestConfiguration withApiVersion(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "apiVersion");
    if (Objects.equal(this.apiVersion, newValue)) return this;
    return new ImmutableListConnectorEntitiesTestConfiguration(this.entitiesPath, this.validationFileName, this.profileName, this.testName, newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link ListConnectorEntitiesTestConfiguration#apiVersion() apiVersion} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for apiVersion
   * @return A modified copy of {@code this} object
   */
  public final ImmutableListConnectorEntitiesTestConfiguration withApiVersion(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.apiVersion, value)) return this;
    return new ImmutableListConnectorEntitiesTestConfiguration(this.entitiesPath, this.validationFileName, this.profileName, this.testName, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableListConnectorEntitiesTestConfiguration} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableListConnectorEntitiesTestConfiguration
        && equalTo((ImmutableListConnectorEntitiesTestConfiguration) another);
  }

  private boolean equalTo(ImmutableListConnectorEntitiesTestConfiguration another) {
    return Objects.equal(entitiesPath, another.entitiesPath)
        && Objects.equal(validationFileName, another.validationFileName)
        && Objects.equal(profileName, another.profileName)
        && Objects.equal(testName, another.testName)
        && Objects.equal(apiVersion, another.apiVersion);
  }

  /**
   * Computes a hash code from attributes: {@code entitiesPath}, {@code validationFileName}, {@code profileName}, {@code testName}, {@code apiVersion}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Objects.hashCode(entitiesPath);
    h = h * 17 + Objects.hashCode(validationFileName);
    h = h * 17 + Objects.hashCode(profileName);
    h = h * 17 + Objects.hashCode(testName);
    h = h * 17 + Objects.hashCode(apiVersion);
    return h;
  }

  /**
   * Prints the immutable value {@code ListConnectorEntitiesTestConfiguration} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ListConnectorEntitiesTestConfiguration")
        .omitNullValues()
        .add("entitiesPath", entitiesPath)
        .add("validationFileName", validationFileName)
        .add("profileName", profileName)
        .add("testName", testName)
        .add("apiVersion", apiVersion)
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
      implements ListConnectorEntitiesTestConfiguration {
    Optional<String> entitiesPath = Optional.empty();
    Optional<String> validationFileName = Optional.empty();
    Optional<String> profileName = Optional.empty();
    Optional<String> testName = Optional.empty();
    Optional<String> apiVersion = Optional.empty();
    @JsonProperty("entitiesPath")
    public void setEntitiesPath(Optional<String> entitiesPath) {
      this.entitiesPath = entitiesPath;
    }
    @JsonProperty("validationFileName")
    public void setValidationFileName(Optional<String> validationFileName) {
      this.validationFileName = validationFileName;
    }
    @JsonProperty("profileName")
    public void setProfileName(Optional<String> profileName) {
      this.profileName = profileName;
    }
    @JsonProperty("testName")
    public void setTestName(Optional<String> testName) {
      this.testName = testName;
    }
    @JsonProperty("apiVersion")
    public void setApiVersion(Optional<String> apiVersion) {
      this.apiVersion = apiVersion;
    }
    @Override
    public Optional<String> entitiesPath() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> validationFileName() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> profileName() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> testName() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> apiVersion() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableListConnectorEntitiesTestConfiguration fromJson(Json json) {
    ImmutableListConnectorEntitiesTestConfiguration.Builder builder = ImmutableListConnectorEntitiesTestConfiguration.builder();
    if (json.entitiesPath != null) {
      builder.entitiesPath(json.entitiesPath);
    }
    if (json.validationFileName != null) {
      builder.validationFileName(json.validationFileName);
    }
    if (json.profileName != null) {
      builder.profileName(json.profileName);
    }
    if (json.testName != null) {
      builder.testName(json.testName);
    }
    if (json.apiVersion != null) {
      builder.apiVersion(json.apiVersion);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link ListConnectorEntitiesTestConfiguration} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ListConnectorEntitiesTestConfiguration instance
   */
  public static ImmutableListConnectorEntitiesTestConfiguration copyOf(ListConnectorEntitiesTestConfiguration instance) {
    if (instance instanceof ImmutableListConnectorEntitiesTestConfiguration) {
      return (ImmutableListConnectorEntitiesTestConfiguration) instance;
    }
    return ImmutableListConnectorEntitiesTestConfiguration.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableListConnectorEntitiesTestConfiguration ImmutableListConnectorEntitiesTestConfiguration}.
   * @return A new ImmutableListConnectorEntitiesTestConfiguration builder
   */
  public static ImmutableListConnectorEntitiesTestConfiguration.Builder builder() {
    return new ImmutableListConnectorEntitiesTestConfiguration.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableListConnectorEntitiesTestConfiguration ImmutableListConnectorEntitiesTestConfiguration}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private @Nullable String entitiesPath;
    private @Nullable String validationFileName;
    private @Nullable String profileName;
    private @Nullable String testName;
    private @Nullable String apiVersion;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ListConnectorEntitiesTestConfiguration} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ListConnectorEntitiesTestConfiguration instance) {
      Preconditions.checkNotNull(instance, "instance");
      Optional<String> entitiesPathOptional = instance.entitiesPath();
      if (entitiesPathOptional.isPresent()) {
        entitiesPath(entitiesPathOptional);
      }
      Optional<String> validationFileNameOptional = instance.validationFileName();
      if (validationFileNameOptional.isPresent()) {
        validationFileName(validationFileNameOptional);
      }
      Optional<String> profileNameOptional = instance.profileName();
      if (profileNameOptional.isPresent()) {
        profileName(profileNameOptional);
      }
      Optional<String> testNameOptional = instance.testName();
      if (testNameOptional.isPresent()) {
        testName(testNameOptional);
      }
      Optional<String> apiVersionOptional = instance.apiVersion();
      if (apiVersionOptional.isPresent()) {
        apiVersion(apiVersionOptional);
      }
      return this;
    }

    /**
     * Initializes the optional value {@link ListConnectorEntitiesTestConfiguration#entitiesPath() entitiesPath} to entitiesPath.
     * @param entitiesPath The value for entitiesPath
     * @return {@code this} builder for chained invocation
     */
    public final Builder entitiesPath(String entitiesPath) {
      this.entitiesPath = Preconditions.checkNotNull(entitiesPath, "entitiesPath");
      return this;
    }

    /**
     * Initializes the optional value {@link ListConnectorEntitiesTestConfiguration#entitiesPath() entitiesPath} to entitiesPath.
     * @param entitiesPath The value for entitiesPath
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entitiesPath(Optional<String> entitiesPath) {
      this.entitiesPath = entitiesPath.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link ListConnectorEntitiesTestConfiguration#validationFileName() validationFileName} to validationFileName.
     * @param validationFileName The value for validationFileName
     * @return {@code this} builder for chained invocation
     */
    public final Builder validationFileName(String validationFileName) {
      this.validationFileName = Preconditions.checkNotNull(validationFileName, "validationFileName");
      return this;
    }

    /**
     * Initializes the optional value {@link ListConnectorEntitiesTestConfiguration#validationFileName() validationFileName} to validationFileName.
     * @param validationFileName The value for validationFileName
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder validationFileName(Optional<String> validationFileName) {
      this.validationFileName = validationFileName.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link ListConnectorEntitiesTestConfiguration#profileName() profileName} to profileName.
     * @param profileName The value for profileName
     * @return {@code this} builder for chained invocation
     */
    public final Builder profileName(String profileName) {
      this.profileName = Preconditions.checkNotNull(profileName, "profileName");
      return this;
    }

    /**
     * Initializes the optional value {@link ListConnectorEntitiesTestConfiguration#profileName() profileName} to profileName.
     * @param profileName The value for profileName
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder profileName(Optional<String> profileName) {
      this.profileName = profileName.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link ListConnectorEntitiesTestConfiguration#testName() testName} to testName.
     * @param testName The value for testName
     * @return {@code this} builder for chained invocation
     */
    public final Builder testName(String testName) {
      this.testName = Preconditions.checkNotNull(testName, "testName");
      return this;
    }

    /**
     * Initializes the optional value {@link ListConnectorEntitiesTestConfiguration#testName() testName} to testName.
     * @param testName The value for testName
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder testName(Optional<String> testName) {
      this.testName = testName.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link ListConnectorEntitiesTestConfiguration#apiVersion() apiVersion} to apiVersion.
     * @param apiVersion The value for apiVersion
     * @return {@code this} builder for chained invocation
     */
    public final Builder apiVersion(String apiVersion) {
      this.apiVersion = Preconditions.checkNotNull(apiVersion, "apiVersion");
      return this;
    }

    /**
     * Initializes the optional value {@link ListConnectorEntitiesTestConfiguration#apiVersion() apiVersion} to apiVersion.
     * @param apiVersion The value for apiVersion
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder apiVersion(Optional<String> apiVersion) {
      this.apiVersion = apiVersion.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ImmutableListConnectorEntitiesTestConfiguration ImmutableListConnectorEntitiesTestConfiguration}.
     * @return An immutable instance of ListConnectorEntitiesTestConfiguration
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableListConnectorEntitiesTestConfiguration build() {
      return new ImmutableListConnectorEntitiesTestConfiguration(entitiesPath, validationFileName, profileName, testName, apiVersion);
    }
  }
}
