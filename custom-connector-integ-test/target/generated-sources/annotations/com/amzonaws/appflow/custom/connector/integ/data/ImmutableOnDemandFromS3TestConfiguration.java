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
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link OnDemandFromS3TestConfiguration}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableOnDemandFromS3TestConfiguration.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableOnDemandFromS3TestConfiguration
    implements OnDemandFromS3TestConfiguration {
  private final @Nullable String testName;
  private final @Nullable String apiVersion;
  private final @Nullable String profileName;
  private final String entityName;
  private final String flowName;
  private final @Nullable List<String> idFieldNames;
  private final String writeOperationType;
  private final @Nullable Integer flowTimeout;
  private final @Nullable String sourceDataFile;
  private final @Nullable String dataGeneratorClassName;
  private final @Nullable Map<String, String> destinationRuntimeSettings;

  private ImmutableOnDemandFromS3TestConfiguration(
      @Nullable String testName,
      @Nullable String apiVersion,
      @Nullable String profileName,
      String entityName,
      String flowName,
      @Nullable List<String> idFieldNames,
      String writeOperationType,
      @Nullable Integer flowTimeout,
      @Nullable String sourceDataFile,
      @Nullable String dataGeneratorClassName,
      @Nullable Map<String, String> destinationRuntimeSettings) {
    this.testName = testName;
    this.apiVersion = apiVersion;
    this.profileName = profileName;
    this.entityName = entityName;
    this.flowName = flowName;
    this.idFieldNames = idFieldNames;
    this.writeOperationType = writeOperationType;
    this.flowTimeout = flowTimeout;
    this.sourceDataFile = sourceDataFile;
    this.dataGeneratorClassName = dataGeneratorClassName;
    this.destinationRuntimeSettings = destinationRuntimeSettings;
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
   * @return The value of the {@code profileName} attribute
   */
  @JsonProperty("profileName")
  @Override
  public Optional<String> profileName() {
    return Optional.ofNullable(profileName);
  }

  /**
   * @return The value of the {@code entityName} attribute
   */
  @JsonProperty("entityName")
  @Override
  public String entityName() {
    return entityName;
  }

  /**
   * @return The value of the {@code flowName} attribute
   */
  @JsonProperty("flowName")
  @Override
  public String flowName() {
    return flowName;
  }

  /**
   * @return The value of the {@code idFieldNames} attribute
   */
  @JsonProperty("idFieldNames")
  @Override
  public Optional<List<String>> idFieldNames() {
    return Optional.ofNullable(idFieldNames);
  }

  /**
   * @return The value of the {@code writeOperationType} attribute
   */
  @JsonProperty("writeOperationType")
  @Override
  public String writeOperationType() {
    return writeOperationType;
  }

  /**
   * @return The value of the {@code flowTimeout} attribute
   */
  @JsonProperty("flowTimeout")
  @Override
  public Optional<Integer> flowTimeout() {
    return Optional.ofNullable(flowTimeout);
  }

  /**
   * @return The value of the {@code sourceDataFile} attribute
   */
  @JsonProperty("sourceDataFile")
  @Override
  public Optional<String> sourceDataFile() {
    return Optional.ofNullable(sourceDataFile);
  }

  /**
   * @return The value of the {@code dataGeneratorClassName} attribute
   */
  @JsonProperty("dataGeneratorClassName")
  @Override
  public Optional<String> dataGeneratorClassName() {
    return Optional.ofNullable(dataGeneratorClassName);
  }

  /**
   * @return The value of the {@code destinationRuntimeSettings} attribute
   */
  @JsonProperty("destinationRuntimeSettings")
  @Override
  public Optional<Map<String, String>> destinationRuntimeSettings() {
    return Optional.ofNullable(destinationRuntimeSettings);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link OnDemandFromS3TestConfiguration#testName() testName} attribute.
   * @param value The value for testName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandFromS3TestConfiguration withTestName(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "testName");
    if (Objects.equal(this.testName, newValue)) return this;
    return new ImmutableOnDemandFromS3TestConfiguration(
        newValue,
        this.apiVersion,
        this.profileName,
        this.entityName,
        this.flowName,
        this.idFieldNames,
        this.writeOperationType,
        this.flowTimeout,
        this.sourceDataFile,
        this.dataGeneratorClassName,
        this.destinationRuntimeSettings);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link OnDemandFromS3TestConfiguration#testName() testName} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for testName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandFromS3TestConfiguration withTestName(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.testName, value)) return this;
    return new ImmutableOnDemandFromS3TestConfiguration(
        value,
        this.apiVersion,
        this.profileName,
        this.entityName,
        this.flowName,
        this.idFieldNames,
        this.writeOperationType,
        this.flowTimeout,
        this.sourceDataFile,
        this.dataGeneratorClassName,
        this.destinationRuntimeSettings);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link OnDemandFromS3TestConfiguration#apiVersion() apiVersion} attribute.
   * @param value The value for apiVersion
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandFromS3TestConfiguration withApiVersion(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "apiVersion");
    if (Objects.equal(this.apiVersion, newValue)) return this;
    return new ImmutableOnDemandFromS3TestConfiguration(
        this.testName,
        newValue,
        this.profileName,
        this.entityName,
        this.flowName,
        this.idFieldNames,
        this.writeOperationType,
        this.flowTimeout,
        this.sourceDataFile,
        this.dataGeneratorClassName,
        this.destinationRuntimeSettings);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link OnDemandFromS3TestConfiguration#apiVersion() apiVersion} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for apiVersion
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandFromS3TestConfiguration withApiVersion(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.apiVersion, value)) return this;
    return new ImmutableOnDemandFromS3TestConfiguration(
        this.testName,
        value,
        this.profileName,
        this.entityName,
        this.flowName,
        this.idFieldNames,
        this.writeOperationType,
        this.flowTimeout,
        this.sourceDataFile,
        this.dataGeneratorClassName,
        this.destinationRuntimeSettings);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link OnDemandFromS3TestConfiguration#profileName() profileName} attribute.
   * @param value The value for profileName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandFromS3TestConfiguration withProfileName(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "profileName");
    if (Objects.equal(this.profileName, newValue)) return this;
    return new ImmutableOnDemandFromS3TestConfiguration(
        this.testName,
        this.apiVersion,
        newValue,
        this.entityName,
        this.flowName,
        this.idFieldNames,
        this.writeOperationType,
        this.flowTimeout,
        this.sourceDataFile,
        this.dataGeneratorClassName,
        this.destinationRuntimeSettings);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link OnDemandFromS3TestConfiguration#profileName() profileName} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for profileName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandFromS3TestConfiguration withProfileName(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.profileName, value)) return this;
    return new ImmutableOnDemandFromS3TestConfiguration(
        this.testName,
        this.apiVersion,
        value,
        this.entityName,
        this.flowName,
        this.idFieldNames,
        this.writeOperationType,
        this.flowTimeout,
        this.sourceDataFile,
        this.dataGeneratorClassName,
        this.destinationRuntimeSettings);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link OnDemandFromS3TestConfiguration#entityName() entityName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param entityName A new value for entityName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableOnDemandFromS3TestConfiguration withEntityName(String entityName) {
    if (this.entityName.equals(entityName)) return this;
    String newValue = Preconditions.checkNotNull(entityName, "entityName");
    return new ImmutableOnDemandFromS3TestConfiguration(
        this.testName,
        this.apiVersion,
        this.profileName,
        newValue,
        this.flowName,
        this.idFieldNames,
        this.writeOperationType,
        this.flowTimeout,
        this.sourceDataFile,
        this.dataGeneratorClassName,
        this.destinationRuntimeSettings);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link OnDemandFromS3TestConfiguration#flowName() flowName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param flowName A new value for flowName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableOnDemandFromS3TestConfiguration withFlowName(String flowName) {
    if (this.flowName.equals(flowName)) return this;
    String newValue = Preconditions.checkNotNull(flowName, "flowName");
    return new ImmutableOnDemandFromS3TestConfiguration(
        this.testName,
        this.apiVersion,
        this.profileName,
        this.entityName,
        newValue,
        this.idFieldNames,
        this.writeOperationType,
        this.flowTimeout,
        this.sourceDataFile,
        this.dataGeneratorClassName,
        this.destinationRuntimeSettings);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link OnDemandFromS3TestConfiguration#idFieldNames() idFieldNames} attribute.
   * @param value The value for idFieldNames
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandFromS3TestConfiguration withIdFieldNames(List<String> value) {
    @Nullable List<String> newValue = Preconditions.checkNotNull(value, "idFieldNames");
    if (this.idFieldNames == newValue) return this;
    return new ImmutableOnDemandFromS3TestConfiguration(
        this.testName,
        this.apiVersion,
        this.profileName,
        this.entityName,
        this.flowName,
        newValue,
        this.writeOperationType,
        this.flowTimeout,
        this.sourceDataFile,
        this.dataGeneratorClassName,
        this.destinationRuntimeSettings);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link OnDemandFromS3TestConfiguration#idFieldNames() idFieldNames} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for idFieldNames
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandFromS3TestConfiguration withIdFieldNames(Optional<List<String>> optional) {
    @Nullable List<String> value = optional.orElse(null);
    if (this.idFieldNames == value) return this;
    return new ImmutableOnDemandFromS3TestConfiguration(
        this.testName,
        this.apiVersion,
        this.profileName,
        this.entityName,
        this.flowName,
        value,
        this.writeOperationType,
        this.flowTimeout,
        this.sourceDataFile,
        this.dataGeneratorClassName,
        this.destinationRuntimeSettings);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link OnDemandFromS3TestConfiguration#writeOperationType() writeOperationType} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param writeOperationType A new value for writeOperationType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableOnDemandFromS3TestConfiguration withWriteOperationType(String writeOperationType) {
    if (this.writeOperationType.equals(writeOperationType)) return this;
    String newValue = Preconditions.checkNotNull(writeOperationType, "writeOperationType");
    return new ImmutableOnDemandFromS3TestConfiguration(
        this.testName,
        this.apiVersion,
        this.profileName,
        this.entityName,
        this.flowName,
        this.idFieldNames,
        newValue,
        this.flowTimeout,
        this.sourceDataFile,
        this.dataGeneratorClassName,
        this.destinationRuntimeSettings);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link OnDemandFromS3TestConfiguration#flowTimeout() flowTimeout} attribute.
   * @param value The value for flowTimeout
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandFromS3TestConfiguration withFlowTimeout(int value) {
    @Nullable Integer newValue = value;
    if (Objects.equal(this.flowTimeout, newValue)) return this;
    return new ImmutableOnDemandFromS3TestConfiguration(
        this.testName,
        this.apiVersion,
        this.profileName,
        this.entityName,
        this.flowName,
        this.idFieldNames,
        this.writeOperationType,
        newValue,
        this.sourceDataFile,
        this.dataGeneratorClassName,
        this.destinationRuntimeSettings);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link OnDemandFromS3TestConfiguration#flowTimeout() flowTimeout} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for flowTimeout
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandFromS3TestConfiguration withFlowTimeout(Optional<Integer> optional) {
    @Nullable Integer value = optional.orElse(null);
    if (Objects.equal(this.flowTimeout, value)) return this;
    return new ImmutableOnDemandFromS3TestConfiguration(
        this.testName,
        this.apiVersion,
        this.profileName,
        this.entityName,
        this.flowName,
        this.idFieldNames,
        this.writeOperationType,
        value,
        this.sourceDataFile,
        this.dataGeneratorClassName,
        this.destinationRuntimeSettings);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link OnDemandFromS3TestConfiguration#sourceDataFile() sourceDataFile} attribute.
   * @param value The value for sourceDataFile
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandFromS3TestConfiguration withSourceDataFile(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "sourceDataFile");
    if (Objects.equal(this.sourceDataFile, newValue)) return this;
    return new ImmutableOnDemandFromS3TestConfiguration(
        this.testName,
        this.apiVersion,
        this.profileName,
        this.entityName,
        this.flowName,
        this.idFieldNames,
        this.writeOperationType,
        this.flowTimeout,
        newValue,
        this.dataGeneratorClassName,
        this.destinationRuntimeSettings);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link OnDemandFromS3TestConfiguration#sourceDataFile() sourceDataFile} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for sourceDataFile
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandFromS3TestConfiguration withSourceDataFile(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.sourceDataFile, value)) return this;
    return new ImmutableOnDemandFromS3TestConfiguration(
        this.testName,
        this.apiVersion,
        this.profileName,
        this.entityName,
        this.flowName,
        this.idFieldNames,
        this.writeOperationType,
        this.flowTimeout,
        value,
        this.dataGeneratorClassName,
        this.destinationRuntimeSettings);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link OnDemandFromS3TestConfiguration#dataGeneratorClassName() dataGeneratorClassName} attribute.
   * @param value The value for dataGeneratorClassName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandFromS3TestConfiguration withDataGeneratorClassName(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "dataGeneratorClassName");
    if (Objects.equal(this.dataGeneratorClassName, newValue)) return this;
    return new ImmutableOnDemandFromS3TestConfiguration(
        this.testName,
        this.apiVersion,
        this.profileName,
        this.entityName,
        this.flowName,
        this.idFieldNames,
        this.writeOperationType,
        this.flowTimeout,
        this.sourceDataFile,
        newValue,
        this.destinationRuntimeSettings);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link OnDemandFromS3TestConfiguration#dataGeneratorClassName() dataGeneratorClassName} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for dataGeneratorClassName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandFromS3TestConfiguration withDataGeneratorClassName(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.dataGeneratorClassName, value)) return this;
    return new ImmutableOnDemandFromS3TestConfiguration(
        this.testName,
        this.apiVersion,
        this.profileName,
        this.entityName,
        this.flowName,
        this.idFieldNames,
        this.writeOperationType,
        this.flowTimeout,
        this.sourceDataFile,
        value,
        this.destinationRuntimeSettings);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link OnDemandFromS3TestConfiguration#destinationRuntimeSettings() destinationRuntimeSettings} attribute.
   * @param value The value for destinationRuntimeSettings
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandFromS3TestConfiguration withDestinationRuntimeSettings(Map<String, String> value) {
    @Nullable Map<String, String> newValue = Preconditions.checkNotNull(value, "destinationRuntimeSettings");
    if (this.destinationRuntimeSettings == newValue) return this;
    return new ImmutableOnDemandFromS3TestConfiguration(
        this.testName,
        this.apiVersion,
        this.profileName,
        this.entityName,
        this.flowName,
        this.idFieldNames,
        this.writeOperationType,
        this.flowTimeout,
        this.sourceDataFile,
        this.dataGeneratorClassName,
        newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link OnDemandFromS3TestConfiguration#destinationRuntimeSettings() destinationRuntimeSettings} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for destinationRuntimeSettings
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandFromS3TestConfiguration withDestinationRuntimeSettings(Optional<Map<String, String>> optional) {
    @Nullable Map<String, String> value = optional.orElse(null);
    if (this.destinationRuntimeSettings == value) return this;
    return new ImmutableOnDemandFromS3TestConfiguration(
        this.testName,
        this.apiVersion,
        this.profileName,
        this.entityName,
        this.flowName,
        this.idFieldNames,
        this.writeOperationType,
        this.flowTimeout,
        this.sourceDataFile,
        this.dataGeneratorClassName,
        value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableOnDemandFromS3TestConfiguration} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableOnDemandFromS3TestConfiguration
        && equalTo((ImmutableOnDemandFromS3TestConfiguration) another);
  }

  private boolean equalTo(ImmutableOnDemandFromS3TestConfiguration another) {
    return Objects.equal(testName, another.testName)
        && Objects.equal(apiVersion, another.apiVersion)
        && Objects.equal(profileName, another.profileName)
        && entityName.equals(another.entityName)
        && flowName.equals(another.flowName)
        && Objects.equal(idFieldNames, another.idFieldNames)
        && writeOperationType.equals(another.writeOperationType)
        && Objects.equal(flowTimeout, another.flowTimeout)
        && Objects.equal(sourceDataFile, another.sourceDataFile)
        && Objects.equal(dataGeneratorClassName, another.dataGeneratorClassName)
        && Objects.equal(destinationRuntimeSettings, another.destinationRuntimeSettings);
  }

  /**
   * Computes a hash code from attributes: {@code testName}, {@code apiVersion}, {@code profileName}, {@code entityName}, {@code flowName}, {@code idFieldNames}, {@code writeOperationType}, {@code flowTimeout}, {@code sourceDataFile}, {@code dataGeneratorClassName}, {@code destinationRuntimeSettings}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Objects.hashCode(testName);
    h = h * 17 + Objects.hashCode(apiVersion);
    h = h * 17 + Objects.hashCode(profileName);
    h = h * 17 + entityName.hashCode();
    h = h * 17 + flowName.hashCode();
    h = h * 17 + Objects.hashCode(idFieldNames);
    h = h * 17 + writeOperationType.hashCode();
    h = h * 17 + Objects.hashCode(flowTimeout);
    h = h * 17 + Objects.hashCode(sourceDataFile);
    h = h * 17 + Objects.hashCode(dataGeneratorClassName);
    h = h * 17 + Objects.hashCode(destinationRuntimeSettings);
    return h;
  }

  /**
   * Prints the immutable value {@code OnDemandFromS3TestConfiguration} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("OnDemandFromS3TestConfiguration")
        .omitNullValues()
        .add("testName", testName)
        .add("apiVersion", apiVersion)
        .add("profileName", profileName)
        .add("entityName", entityName)
        .add("flowName", flowName)
        .add("idFieldNames", idFieldNames)
        .add("writeOperationType", writeOperationType)
        .add("flowTimeout", flowTimeout)
        .add("sourceDataFile", sourceDataFile)
        .add("dataGeneratorClassName", dataGeneratorClassName)
        .add("destinationRuntimeSettings", destinationRuntimeSettings)
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
      implements OnDemandFromS3TestConfiguration {
    Optional<String> testName = Optional.empty();
    Optional<String> apiVersion = Optional.empty();
    Optional<String> profileName = Optional.empty();
    @Nullable String entityName;
    @Nullable String flowName;
    Optional<List<String>> idFieldNames = Optional.empty();
    @Nullable String writeOperationType;
    Optional<Integer> flowTimeout = Optional.empty();
    Optional<String> sourceDataFile = Optional.empty();
    Optional<String> dataGeneratorClassName = Optional.empty();
    Optional<Map<String, String>> destinationRuntimeSettings = Optional.empty();
    @JsonProperty("testName")
    public void setTestName(Optional<String> testName) {
      this.testName = testName;
    }
    @JsonProperty("apiVersion")
    public void setApiVersion(Optional<String> apiVersion) {
      this.apiVersion = apiVersion;
    }
    @JsonProperty("profileName")
    public void setProfileName(Optional<String> profileName) {
      this.profileName = profileName;
    }
    @JsonProperty("entityName")
    public void setEntityName(String entityName) {
      this.entityName = entityName;
    }
    @JsonProperty("flowName")
    public void setFlowName(String flowName) {
      this.flowName = flowName;
    }
    @JsonProperty("idFieldNames")
    public void setIdFieldNames(Optional<List<String>> idFieldNames) {
      this.idFieldNames = idFieldNames;
    }
    @JsonProperty("writeOperationType")
    public void setWriteOperationType(String writeOperationType) {
      this.writeOperationType = writeOperationType;
    }
    @JsonProperty("flowTimeout")
    public void setFlowTimeout(Optional<Integer> flowTimeout) {
      this.flowTimeout = flowTimeout;
    }
    @JsonProperty("sourceDataFile")
    public void setSourceDataFile(Optional<String> sourceDataFile) {
      this.sourceDataFile = sourceDataFile;
    }
    @JsonProperty("dataGeneratorClassName")
    public void setDataGeneratorClassName(Optional<String> dataGeneratorClassName) {
      this.dataGeneratorClassName = dataGeneratorClassName;
    }
    @JsonProperty("destinationRuntimeSettings")
    public void setDestinationRuntimeSettings(Optional<Map<String, String>> destinationRuntimeSettings) {
      this.destinationRuntimeSettings = destinationRuntimeSettings;
    }
    @Override
    public Optional<String> testName() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> apiVersion() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> profileName() { throw new UnsupportedOperationException(); }
    @Override
    public String entityName() { throw new UnsupportedOperationException(); }
    @Override
    public String flowName() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<List<String>> idFieldNames() { throw new UnsupportedOperationException(); }
    @Override
    public String writeOperationType() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<Integer> flowTimeout() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> sourceDataFile() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> dataGeneratorClassName() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<Map<String, String>> destinationRuntimeSettings() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableOnDemandFromS3TestConfiguration fromJson(Json json) {
    ImmutableOnDemandFromS3TestConfiguration.Builder builder = ImmutableOnDemandFromS3TestConfiguration.builder();
    if (json.testName != null) {
      builder.testName(json.testName);
    }
    if (json.apiVersion != null) {
      builder.apiVersion(json.apiVersion);
    }
    if (json.profileName != null) {
      builder.profileName(json.profileName);
    }
    if (json.entityName != null) {
      builder.entityName(json.entityName);
    }
    if (json.flowName != null) {
      builder.flowName(json.flowName);
    }
    if (json.idFieldNames != null) {
      builder.idFieldNames(json.idFieldNames);
    }
    if (json.writeOperationType != null) {
      builder.writeOperationType(json.writeOperationType);
    }
    if (json.flowTimeout != null) {
      builder.flowTimeout(json.flowTimeout);
    }
    if (json.sourceDataFile != null) {
      builder.sourceDataFile(json.sourceDataFile);
    }
    if (json.dataGeneratorClassName != null) {
      builder.dataGeneratorClassName(json.dataGeneratorClassName);
    }
    if (json.destinationRuntimeSettings != null) {
      builder.destinationRuntimeSettings(json.destinationRuntimeSettings);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link OnDemandFromS3TestConfiguration} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable OnDemandFromS3TestConfiguration instance
   */
  public static ImmutableOnDemandFromS3TestConfiguration copyOf(OnDemandFromS3TestConfiguration instance) {
    if (instance instanceof ImmutableOnDemandFromS3TestConfiguration) {
      return (ImmutableOnDemandFromS3TestConfiguration) instance;
    }
    return ImmutableOnDemandFromS3TestConfiguration.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableOnDemandFromS3TestConfiguration ImmutableOnDemandFromS3TestConfiguration}.
   * @return A new ImmutableOnDemandFromS3TestConfiguration builder
   */
  public static ImmutableOnDemandFromS3TestConfiguration.Builder builder() {
    return new ImmutableOnDemandFromS3TestConfiguration.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableOnDemandFromS3TestConfiguration ImmutableOnDemandFromS3TestConfiguration}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ENTITY_NAME = 0x1L;
    private static final long INIT_BIT_FLOW_NAME = 0x2L;
    private static final long INIT_BIT_WRITE_OPERATION_TYPE = 0x4L;
    private long initBits = 0x7L;

    private @Nullable String testName;
    private @Nullable String apiVersion;
    private @Nullable String profileName;
    private @Nullable String entityName;
    private @Nullable String flowName;
    private @Nullable List<String> idFieldNames;
    private @Nullable String writeOperationType;
    private @Nullable Integer flowTimeout;
    private @Nullable String sourceDataFile;
    private @Nullable String dataGeneratorClassName;
    private @Nullable Map<String, String> destinationRuntimeSettings;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code OnDemandFromS3TestConfiguration} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(OnDemandFromS3TestConfiguration instance) {
      Preconditions.checkNotNull(instance, "instance");
      Optional<String> testNameOptional = instance.testName();
      if (testNameOptional.isPresent()) {
        testName(testNameOptional);
      }
      Optional<String> apiVersionOptional = instance.apiVersion();
      if (apiVersionOptional.isPresent()) {
        apiVersion(apiVersionOptional);
      }
      Optional<String> profileNameOptional = instance.profileName();
      if (profileNameOptional.isPresent()) {
        profileName(profileNameOptional);
      }
      entityName(instance.entityName());
      flowName(instance.flowName());
      Optional<List<String>> idFieldNamesOptional = instance.idFieldNames();
      if (idFieldNamesOptional.isPresent()) {
        idFieldNames(idFieldNamesOptional);
      }
      writeOperationType(instance.writeOperationType());
      Optional<Integer> flowTimeoutOptional = instance.flowTimeout();
      if (flowTimeoutOptional.isPresent()) {
        flowTimeout(flowTimeoutOptional);
      }
      Optional<String> sourceDataFileOptional = instance.sourceDataFile();
      if (sourceDataFileOptional.isPresent()) {
        sourceDataFile(sourceDataFileOptional);
      }
      Optional<String> dataGeneratorClassNameOptional = instance.dataGeneratorClassName();
      if (dataGeneratorClassNameOptional.isPresent()) {
        dataGeneratorClassName(dataGeneratorClassNameOptional);
      }
      Optional<Map<String, String>> destinationRuntimeSettingsOptional = instance.destinationRuntimeSettings();
      if (destinationRuntimeSettingsOptional.isPresent()) {
        destinationRuntimeSettings(destinationRuntimeSettingsOptional);
      }
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandFromS3TestConfiguration#testName() testName} to testName.
     * @param testName The value for testName
     * @return {@code this} builder for chained invocation
     */
    public final Builder testName(String testName) {
      this.testName = Preconditions.checkNotNull(testName, "testName");
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandFromS3TestConfiguration#testName() testName} to testName.
     * @param testName The value for testName
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder testName(Optional<String> testName) {
      this.testName = testName.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandFromS3TestConfiguration#apiVersion() apiVersion} to apiVersion.
     * @param apiVersion The value for apiVersion
     * @return {@code this} builder for chained invocation
     */
    public final Builder apiVersion(String apiVersion) {
      this.apiVersion = Preconditions.checkNotNull(apiVersion, "apiVersion");
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandFromS3TestConfiguration#apiVersion() apiVersion} to apiVersion.
     * @param apiVersion The value for apiVersion
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder apiVersion(Optional<String> apiVersion) {
      this.apiVersion = apiVersion.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandFromS3TestConfiguration#profileName() profileName} to profileName.
     * @param profileName The value for profileName
     * @return {@code this} builder for chained invocation
     */
    public final Builder profileName(String profileName) {
      this.profileName = Preconditions.checkNotNull(profileName, "profileName");
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandFromS3TestConfiguration#profileName() profileName} to profileName.
     * @param profileName The value for profileName
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder profileName(Optional<String> profileName) {
      this.profileName = profileName.orElse(null);
      return this;
    }

    /**
     * Initializes the value for the {@link OnDemandFromS3TestConfiguration#entityName() entityName} attribute.
     * @param entityName The value for entityName 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entityName(String entityName) {
      this.entityName = Preconditions.checkNotNull(entityName, "entityName");
      initBits &= ~INIT_BIT_ENTITY_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link OnDemandFromS3TestConfiguration#flowName() flowName} attribute.
     * @param flowName The value for flowName 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder flowName(String flowName) {
      this.flowName = Preconditions.checkNotNull(flowName, "flowName");
      initBits &= ~INIT_BIT_FLOW_NAME;
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandFromS3TestConfiguration#idFieldNames() idFieldNames} to idFieldNames.
     * @param idFieldNames The value for idFieldNames
     * @return {@code this} builder for chained invocation
     */
    public final Builder idFieldNames(List<String> idFieldNames) {
      this.idFieldNames = Preconditions.checkNotNull(idFieldNames, "idFieldNames");
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandFromS3TestConfiguration#idFieldNames() idFieldNames} to idFieldNames.
     * @param idFieldNames The value for idFieldNames
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder idFieldNames(Optional<List<String>> idFieldNames) {
      this.idFieldNames = idFieldNames.orElse(null);
      return this;
    }

    /**
     * Initializes the value for the {@link OnDemandFromS3TestConfiguration#writeOperationType() writeOperationType} attribute.
     * @param writeOperationType The value for writeOperationType 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder writeOperationType(String writeOperationType) {
      this.writeOperationType = Preconditions.checkNotNull(writeOperationType, "writeOperationType");
      initBits &= ~INIT_BIT_WRITE_OPERATION_TYPE;
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandFromS3TestConfiguration#flowTimeout() flowTimeout} to flowTimeout.
     * @param flowTimeout The value for flowTimeout
     * @return {@code this} builder for chained invocation
     */
    public final Builder flowTimeout(int flowTimeout) {
      this.flowTimeout = flowTimeout;
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandFromS3TestConfiguration#flowTimeout() flowTimeout} to flowTimeout.
     * @param flowTimeout The value for flowTimeout
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder flowTimeout(Optional<Integer> flowTimeout) {
      this.flowTimeout = flowTimeout.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandFromS3TestConfiguration#sourceDataFile() sourceDataFile} to sourceDataFile.
     * @param sourceDataFile The value for sourceDataFile
     * @return {@code this} builder for chained invocation
     */
    public final Builder sourceDataFile(String sourceDataFile) {
      this.sourceDataFile = Preconditions.checkNotNull(sourceDataFile, "sourceDataFile");
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandFromS3TestConfiguration#sourceDataFile() sourceDataFile} to sourceDataFile.
     * @param sourceDataFile The value for sourceDataFile
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder sourceDataFile(Optional<String> sourceDataFile) {
      this.sourceDataFile = sourceDataFile.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandFromS3TestConfiguration#dataGeneratorClassName() dataGeneratorClassName} to dataGeneratorClassName.
     * @param dataGeneratorClassName The value for dataGeneratorClassName
     * @return {@code this} builder for chained invocation
     */
    public final Builder dataGeneratorClassName(String dataGeneratorClassName) {
      this.dataGeneratorClassName = Preconditions.checkNotNull(dataGeneratorClassName, "dataGeneratorClassName");
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandFromS3TestConfiguration#dataGeneratorClassName() dataGeneratorClassName} to dataGeneratorClassName.
     * @param dataGeneratorClassName The value for dataGeneratorClassName
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder dataGeneratorClassName(Optional<String> dataGeneratorClassName) {
      this.dataGeneratorClassName = dataGeneratorClassName.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandFromS3TestConfiguration#destinationRuntimeSettings() destinationRuntimeSettings} to destinationRuntimeSettings.
     * @param destinationRuntimeSettings The value for destinationRuntimeSettings
     * @return {@code this} builder for chained invocation
     */
    public final Builder destinationRuntimeSettings(Map<String, String> destinationRuntimeSettings) {
      this.destinationRuntimeSettings = Preconditions.checkNotNull(destinationRuntimeSettings, "destinationRuntimeSettings");
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandFromS3TestConfiguration#destinationRuntimeSettings() destinationRuntimeSettings} to destinationRuntimeSettings.
     * @param destinationRuntimeSettings The value for destinationRuntimeSettings
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder destinationRuntimeSettings(Optional<Map<String, String>> destinationRuntimeSettings) {
      this.destinationRuntimeSettings = destinationRuntimeSettings.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ImmutableOnDemandFromS3TestConfiguration ImmutableOnDemandFromS3TestConfiguration}.
     * @return An immutable instance of OnDemandFromS3TestConfiguration
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableOnDemandFromS3TestConfiguration build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableOnDemandFromS3TestConfiguration(
          testName,
          apiVersion,
          profileName,
          entityName,
          flowName,
          idFieldNames,
          writeOperationType,
          flowTimeout,
          sourceDataFile,
          dataGeneratorClassName,
          destinationRuntimeSettings);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_ENTITY_NAME) != 0) attributes.add("entityName");
      if ((initBits & INIT_BIT_FLOW_NAME) != 0) attributes.add("flowName");
      if ((initBits & INIT_BIT_WRITE_OPERATION_TYPE) != 0) attributes.add("writeOperationType");
      return "Cannot build OnDemandFromS3TestConfiguration, some of required attributes are not set " + attributes;
    }
  }
}
