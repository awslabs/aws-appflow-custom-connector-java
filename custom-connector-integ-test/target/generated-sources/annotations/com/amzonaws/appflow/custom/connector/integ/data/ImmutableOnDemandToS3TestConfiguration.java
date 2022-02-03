package com.amzonaws.appflow.custom.connector.integ.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link OnDemandToS3TestConfiguration}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableOnDemandToS3TestConfiguration.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableOnDemandToS3TestConfiguration
    implements OnDemandToS3TestConfiguration {
  private final @Nullable String testName;
  private final @Nullable String apiVersion;
  private final @Nullable String profileName;
  private final String flowName;
  private final String entityName;
  private final @Nullable String query;
  private final @Nullable Integer flowTimeout;
  private final ImmutableList<String> entityFields;
  private final @Nullable Long outputSize;
  private final @Nullable Map<String, String> sourceRuntimeProperties;

  private ImmutableOnDemandToS3TestConfiguration(
      @Nullable String testName,
      @Nullable String apiVersion,
      @Nullable String profileName,
      String flowName,
      String entityName,
      @Nullable String query,
      @Nullable Integer flowTimeout,
      ImmutableList<String> entityFields,
      @Nullable Long outputSize,
      @Nullable Map<String, String> sourceRuntimeProperties) {
    this.testName = testName;
    this.apiVersion = apiVersion;
    this.profileName = profileName;
    this.flowName = flowName;
    this.entityName = entityName;
    this.query = query;
    this.flowTimeout = flowTimeout;
    this.entityFields = entityFields;
    this.outputSize = outputSize;
    this.sourceRuntimeProperties = sourceRuntimeProperties;
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
   * @return The value of the {@code flowName} attribute
   */
  @JsonProperty("flowName")
  @Override
  public String flowName() {
    return flowName;
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
   * @return The value of the {@code query} attribute
   */
  @JsonProperty("query")
  @Override
  public Optional<String> query() {
    return Optional.ofNullable(query);
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
   * @return The value of the {@code entityFields} attribute
   */
  @JsonProperty("entityFields")
  @Override
  public ImmutableList<String> entityFields() {
    return entityFields;
  }

  /**
   * @return The value of the {@code outputSize} attribute
   */
  @JsonProperty("outputSize")
  @Override
  public Optional<Long> outputSize() {
    return Optional.ofNullable(outputSize);
  }

  /**
   * @return The value of the {@code sourceRuntimeProperties} attribute
   */
  @JsonProperty("sourceRuntimeProperties")
  @Override
  public Optional<Map<String, String>> sourceRuntimeProperties() {
    return Optional.ofNullable(sourceRuntimeProperties);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link OnDemandToS3TestConfiguration#testName() testName} attribute.
   * @param value The value for testName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandToS3TestConfiguration withTestName(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "testName");
    if (Objects.equal(this.testName, newValue)) return this;
    return new ImmutableOnDemandToS3TestConfiguration(
        newValue,
        this.apiVersion,
        this.profileName,
        this.flowName,
        this.entityName,
        this.query,
        this.flowTimeout,
        this.entityFields,
        this.outputSize,
        this.sourceRuntimeProperties);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link OnDemandToS3TestConfiguration#testName() testName} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for testName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandToS3TestConfiguration withTestName(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.testName, value)) return this;
    return new ImmutableOnDemandToS3TestConfiguration(
        value,
        this.apiVersion,
        this.profileName,
        this.flowName,
        this.entityName,
        this.query,
        this.flowTimeout,
        this.entityFields,
        this.outputSize,
        this.sourceRuntimeProperties);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link OnDemandToS3TestConfiguration#apiVersion() apiVersion} attribute.
   * @param value The value for apiVersion
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandToS3TestConfiguration withApiVersion(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "apiVersion");
    if (Objects.equal(this.apiVersion, newValue)) return this;
    return new ImmutableOnDemandToS3TestConfiguration(
        this.testName,
        newValue,
        this.profileName,
        this.flowName,
        this.entityName,
        this.query,
        this.flowTimeout,
        this.entityFields,
        this.outputSize,
        this.sourceRuntimeProperties);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link OnDemandToS3TestConfiguration#apiVersion() apiVersion} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for apiVersion
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandToS3TestConfiguration withApiVersion(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.apiVersion, value)) return this;
    return new ImmutableOnDemandToS3TestConfiguration(
        this.testName,
        value,
        this.profileName,
        this.flowName,
        this.entityName,
        this.query,
        this.flowTimeout,
        this.entityFields,
        this.outputSize,
        this.sourceRuntimeProperties);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link OnDemandToS3TestConfiguration#profileName() profileName} attribute.
   * @param value The value for profileName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandToS3TestConfiguration withProfileName(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "profileName");
    if (Objects.equal(this.profileName, newValue)) return this;
    return new ImmutableOnDemandToS3TestConfiguration(
        this.testName,
        this.apiVersion,
        newValue,
        this.flowName,
        this.entityName,
        this.query,
        this.flowTimeout,
        this.entityFields,
        this.outputSize,
        this.sourceRuntimeProperties);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link OnDemandToS3TestConfiguration#profileName() profileName} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for profileName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandToS3TestConfiguration withProfileName(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.profileName, value)) return this;
    return new ImmutableOnDemandToS3TestConfiguration(
        this.testName,
        this.apiVersion,
        value,
        this.flowName,
        this.entityName,
        this.query,
        this.flowTimeout,
        this.entityFields,
        this.outputSize,
        this.sourceRuntimeProperties);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link OnDemandToS3TestConfiguration#flowName() flowName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param flowName A new value for flowName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableOnDemandToS3TestConfiguration withFlowName(String flowName) {
    if (this.flowName.equals(flowName)) return this;
    String newValue = Preconditions.checkNotNull(flowName, "flowName");
    return new ImmutableOnDemandToS3TestConfiguration(
        this.testName,
        this.apiVersion,
        this.profileName,
        newValue,
        this.entityName,
        this.query,
        this.flowTimeout,
        this.entityFields,
        this.outputSize,
        this.sourceRuntimeProperties);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link OnDemandToS3TestConfiguration#entityName() entityName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param entityName A new value for entityName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableOnDemandToS3TestConfiguration withEntityName(String entityName) {
    if (this.entityName.equals(entityName)) return this;
    String newValue = Preconditions.checkNotNull(entityName, "entityName");
    return new ImmutableOnDemandToS3TestConfiguration(
        this.testName,
        this.apiVersion,
        this.profileName,
        this.flowName,
        newValue,
        this.query,
        this.flowTimeout,
        this.entityFields,
        this.outputSize,
        this.sourceRuntimeProperties);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link OnDemandToS3TestConfiguration#query() query} attribute.
   * @param value The value for query
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandToS3TestConfiguration withQuery(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "query");
    if (Objects.equal(this.query, newValue)) return this;
    return new ImmutableOnDemandToS3TestConfiguration(
        this.testName,
        this.apiVersion,
        this.profileName,
        this.flowName,
        this.entityName,
        newValue,
        this.flowTimeout,
        this.entityFields,
        this.outputSize,
        this.sourceRuntimeProperties);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link OnDemandToS3TestConfiguration#query() query} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for query
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandToS3TestConfiguration withQuery(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.query, value)) return this;
    return new ImmutableOnDemandToS3TestConfiguration(
        this.testName,
        this.apiVersion,
        this.profileName,
        this.flowName,
        this.entityName,
        value,
        this.flowTimeout,
        this.entityFields,
        this.outputSize,
        this.sourceRuntimeProperties);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link OnDemandToS3TestConfiguration#flowTimeout() flowTimeout} attribute.
   * @param value The value for flowTimeout
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandToS3TestConfiguration withFlowTimeout(int value) {
    @Nullable Integer newValue = value;
    if (Objects.equal(this.flowTimeout, newValue)) return this;
    return new ImmutableOnDemandToS3TestConfiguration(
        this.testName,
        this.apiVersion,
        this.profileName,
        this.flowName,
        this.entityName,
        this.query,
        newValue,
        this.entityFields,
        this.outputSize,
        this.sourceRuntimeProperties);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link OnDemandToS3TestConfiguration#flowTimeout() flowTimeout} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for flowTimeout
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandToS3TestConfiguration withFlowTimeout(Optional<Integer> optional) {
    @Nullable Integer value = optional.orElse(null);
    if (Objects.equal(this.flowTimeout, value)) return this;
    return new ImmutableOnDemandToS3TestConfiguration(
        this.testName,
        this.apiVersion,
        this.profileName,
        this.flowName,
        this.entityName,
        this.query,
        value,
        this.entityFields,
        this.outputSize,
        this.sourceRuntimeProperties);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link OnDemandToS3TestConfiguration#entityFields() entityFields}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandToS3TestConfiguration withEntityFields(String... elements) {
    ImmutableList<String> newValue = ImmutableList.copyOf(elements);
    return new ImmutableOnDemandToS3TestConfiguration(
        this.testName,
        this.apiVersion,
        this.profileName,
        this.flowName,
        this.entityName,
        this.query,
        this.flowTimeout,
        newValue,
        this.outputSize,
        this.sourceRuntimeProperties);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link OnDemandToS3TestConfiguration#entityFields() entityFields}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of entityFields elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandToS3TestConfiguration withEntityFields(Iterable<String> elements) {
    if (this.entityFields == elements) return this;
    ImmutableList<String> newValue = ImmutableList.copyOf(elements);
    return new ImmutableOnDemandToS3TestConfiguration(
        this.testName,
        this.apiVersion,
        this.profileName,
        this.flowName,
        this.entityName,
        this.query,
        this.flowTimeout,
        newValue,
        this.outputSize,
        this.sourceRuntimeProperties);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link OnDemandToS3TestConfiguration#outputSize() outputSize} attribute.
   * @param value The value for outputSize
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandToS3TestConfiguration withOutputSize(long value) {
    @Nullable Long newValue = value;
    if (Objects.equal(this.outputSize, newValue)) return this;
    return new ImmutableOnDemandToS3TestConfiguration(
        this.testName,
        this.apiVersion,
        this.profileName,
        this.flowName,
        this.entityName,
        this.query,
        this.flowTimeout,
        this.entityFields,
        newValue,
        this.sourceRuntimeProperties);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link OnDemandToS3TestConfiguration#outputSize() outputSize} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for outputSize
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandToS3TestConfiguration withOutputSize(Optional<Long> optional) {
    @Nullable Long value = optional.orElse(null);
    if (Objects.equal(this.outputSize, value)) return this;
    return new ImmutableOnDemandToS3TestConfiguration(
        this.testName,
        this.apiVersion,
        this.profileName,
        this.flowName,
        this.entityName,
        this.query,
        this.flowTimeout,
        this.entityFields,
        value,
        this.sourceRuntimeProperties);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link OnDemandToS3TestConfiguration#sourceRuntimeProperties() sourceRuntimeProperties} attribute.
   * @param value The value for sourceRuntimeProperties
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandToS3TestConfiguration withSourceRuntimeProperties(Map<String, String> value) {
    @Nullable Map<String, String> newValue = Preconditions.checkNotNull(value, "sourceRuntimeProperties");
    if (this.sourceRuntimeProperties == newValue) return this;
    return new ImmutableOnDemandToS3TestConfiguration(
        this.testName,
        this.apiVersion,
        this.profileName,
        this.flowName,
        this.entityName,
        this.query,
        this.flowTimeout,
        this.entityFields,
        this.outputSize,
        newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link OnDemandToS3TestConfiguration#sourceRuntimeProperties() sourceRuntimeProperties} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for sourceRuntimeProperties
   * @return A modified copy of {@code this} object
   */
  public final ImmutableOnDemandToS3TestConfiguration withSourceRuntimeProperties(Optional<Map<String, String>> optional) {
    @Nullable Map<String, String> value = optional.orElse(null);
    if (this.sourceRuntimeProperties == value) return this;
    return new ImmutableOnDemandToS3TestConfiguration(
        this.testName,
        this.apiVersion,
        this.profileName,
        this.flowName,
        this.entityName,
        this.query,
        this.flowTimeout,
        this.entityFields,
        this.outputSize,
        value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableOnDemandToS3TestConfiguration} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableOnDemandToS3TestConfiguration
        && equalTo((ImmutableOnDemandToS3TestConfiguration) another);
  }

  private boolean equalTo(ImmutableOnDemandToS3TestConfiguration another) {
    return Objects.equal(testName, another.testName)
        && Objects.equal(apiVersion, another.apiVersion)
        && Objects.equal(profileName, another.profileName)
        && flowName.equals(another.flowName)
        && entityName.equals(another.entityName)
        && Objects.equal(query, another.query)
        && Objects.equal(flowTimeout, another.flowTimeout)
        && entityFields.equals(another.entityFields)
        && Objects.equal(outputSize, another.outputSize)
        && Objects.equal(sourceRuntimeProperties, another.sourceRuntimeProperties);
  }

  /**
   * Computes a hash code from attributes: {@code testName}, {@code apiVersion}, {@code profileName}, {@code flowName}, {@code entityName}, {@code query}, {@code flowTimeout}, {@code entityFields}, {@code outputSize}, {@code sourceRuntimeProperties}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Objects.hashCode(testName);
    h = h * 17 + Objects.hashCode(apiVersion);
    h = h * 17 + Objects.hashCode(profileName);
    h = h * 17 + flowName.hashCode();
    h = h * 17 + entityName.hashCode();
    h = h * 17 + Objects.hashCode(query);
    h = h * 17 + Objects.hashCode(flowTimeout);
    h = h * 17 + entityFields.hashCode();
    h = h * 17 + Objects.hashCode(outputSize);
    h = h * 17 + Objects.hashCode(sourceRuntimeProperties);
    return h;
  }

  /**
   * Prints the immutable value {@code OnDemandToS3TestConfiguration} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("OnDemandToS3TestConfiguration")
        .omitNullValues()
        .add("testName", testName)
        .add("apiVersion", apiVersion)
        .add("profileName", profileName)
        .add("flowName", flowName)
        .add("entityName", entityName)
        .add("query", query)
        .add("flowTimeout", flowTimeout)
        .add("entityFields", entityFields)
        .add("outputSize", outputSize)
        .add("sourceRuntimeProperties", sourceRuntimeProperties)
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
      implements OnDemandToS3TestConfiguration {
    Optional<String> testName = Optional.empty();
    Optional<String> apiVersion = Optional.empty();
    Optional<String> profileName = Optional.empty();
    @Nullable String flowName;
    @Nullable String entityName;
    Optional<String> query = Optional.empty();
    Optional<Integer> flowTimeout = Optional.empty();
    List<String> entityFields = ImmutableList.of();
    Optional<Long> outputSize = Optional.empty();
    Optional<Map<String, String>> sourceRuntimeProperties = Optional.empty();
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
    @JsonProperty("flowName")
    public void setFlowName(String flowName) {
      this.flowName = flowName;
    }
    @JsonProperty("entityName")
    public void setEntityName(String entityName) {
      this.entityName = entityName;
    }
    @JsonProperty("query")
    public void setQuery(Optional<String> query) {
      this.query = query;
    }
    @JsonProperty("flowTimeout")
    public void setFlowTimeout(Optional<Integer> flowTimeout) {
      this.flowTimeout = flowTimeout;
    }
    @JsonProperty("entityFields")
    public void setEntityFields(List<String> entityFields) {
      this.entityFields = entityFields;
    }
    @JsonProperty("outputSize")
    public void setOutputSize(Optional<Long> outputSize) {
      this.outputSize = outputSize;
    }
    @JsonProperty("sourceRuntimeProperties")
    public void setSourceRuntimeProperties(Optional<Map<String, String>> sourceRuntimeProperties) {
      this.sourceRuntimeProperties = sourceRuntimeProperties;
    }
    @Override
    public Optional<String> testName() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> apiVersion() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> profileName() { throw new UnsupportedOperationException(); }
    @Override
    public String flowName() { throw new UnsupportedOperationException(); }
    @Override
    public String entityName() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> query() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<Integer> flowTimeout() { throw new UnsupportedOperationException(); }
    @Override
    public List<String> entityFields() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<Long> outputSize() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<Map<String, String>> sourceRuntimeProperties() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableOnDemandToS3TestConfiguration fromJson(Json json) {
    ImmutableOnDemandToS3TestConfiguration.Builder builder = ImmutableOnDemandToS3TestConfiguration.builder();
    if (json.testName != null) {
      builder.testName(json.testName);
    }
    if (json.apiVersion != null) {
      builder.apiVersion(json.apiVersion);
    }
    if (json.profileName != null) {
      builder.profileName(json.profileName);
    }
    if (json.flowName != null) {
      builder.flowName(json.flowName);
    }
    if (json.entityName != null) {
      builder.entityName(json.entityName);
    }
    if (json.query != null) {
      builder.query(json.query);
    }
    if (json.flowTimeout != null) {
      builder.flowTimeout(json.flowTimeout);
    }
    if (json.entityFields != null) {
      builder.addAllEntityFields(json.entityFields);
    }
    if (json.outputSize != null) {
      builder.outputSize(json.outputSize);
    }
    if (json.sourceRuntimeProperties != null) {
      builder.sourceRuntimeProperties(json.sourceRuntimeProperties);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link OnDemandToS3TestConfiguration} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable OnDemandToS3TestConfiguration instance
   */
  public static ImmutableOnDemandToS3TestConfiguration copyOf(OnDemandToS3TestConfiguration instance) {
    if (instance instanceof ImmutableOnDemandToS3TestConfiguration) {
      return (ImmutableOnDemandToS3TestConfiguration) instance;
    }
    return ImmutableOnDemandToS3TestConfiguration.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableOnDemandToS3TestConfiguration ImmutableOnDemandToS3TestConfiguration}.
   * @return A new ImmutableOnDemandToS3TestConfiguration builder
   */
  public static ImmutableOnDemandToS3TestConfiguration.Builder builder() {
    return new ImmutableOnDemandToS3TestConfiguration.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableOnDemandToS3TestConfiguration ImmutableOnDemandToS3TestConfiguration}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_FLOW_NAME = 0x1L;
    private static final long INIT_BIT_ENTITY_NAME = 0x2L;
    private long initBits = 0x3L;

    private @Nullable String testName;
    private @Nullable String apiVersion;
    private @Nullable String profileName;
    private @Nullable String flowName;
    private @Nullable String entityName;
    private @Nullable String query;
    private @Nullable Integer flowTimeout;
    private ImmutableList.Builder<String> entityFields = ImmutableList.builder();
    private @Nullable Long outputSize;
    private @Nullable Map<String, String> sourceRuntimeProperties;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code OnDemandToS3TestConfiguration} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(OnDemandToS3TestConfiguration instance) {
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
      flowName(instance.flowName());
      entityName(instance.entityName());
      Optional<String> queryOptional = instance.query();
      if (queryOptional.isPresent()) {
        query(queryOptional);
      }
      Optional<Integer> flowTimeoutOptional = instance.flowTimeout();
      if (flowTimeoutOptional.isPresent()) {
        flowTimeout(flowTimeoutOptional);
      }
      addAllEntityFields(instance.entityFields());
      Optional<Long> outputSizeOptional = instance.outputSize();
      if (outputSizeOptional.isPresent()) {
        outputSize(outputSizeOptional);
      }
      Optional<Map<String, String>> sourceRuntimePropertiesOptional = instance.sourceRuntimeProperties();
      if (sourceRuntimePropertiesOptional.isPresent()) {
        sourceRuntimeProperties(sourceRuntimePropertiesOptional);
      }
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandToS3TestConfiguration#testName() testName} to testName.
     * @param testName The value for testName
     * @return {@code this} builder for chained invocation
     */
    public final Builder testName(String testName) {
      this.testName = Preconditions.checkNotNull(testName, "testName");
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandToS3TestConfiguration#testName() testName} to testName.
     * @param testName The value for testName
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder testName(Optional<String> testName) {
      this.testName = testName.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandToS3TestConfiguration#apiVersion() apiVersion} to apiVersion.
     * @param apiVersion The value for apiVersion
     * @return {@code this} builder for chained invocation
     */
    public final Builder apiVersion(String apiVersion) {
      this.apiVersion = Preconditions.checkNotNull(apiVersion, "apiVersion");
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandToS3TestConfiguration#apiVersion() apiVersion} to apiVersion.
     * @param apiVersion The value for apiVersion
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder apiVersion(Optional<String> apiVersion) {
      this.apiVersion = apiVersion.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandToS3TestConfiguration#profileName() profileName} to profileName.
     * @param profileName The value for profileName
     * @return {@code this} builder for chained invocation
     */
    public final Builder profileName(String profileName) {
      this.profileName = Preconditions.checkNotNull(profileName, "profileName");
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandToS3TestConfiguration#profileName() profileName} to profileName.
     * @param profileName The value for profileName
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder profileName(Optional<String> profileName) {
      this.profileName = profileName.orElse(null);
      return this;
    }

    /**
     * Initializes the value for the {@link OnDemandToS3TestConfiguration#flowName() flowName} attribute.
     * @param flowName The value for flowName 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder flowName(String flowName) {
      this.flowName = Preconditions.checkNotNull(flowName, "flowName");
      initBits &= ~INIT_BIT_FLOW_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link OnDemandToS3TestConfiguration#entityName() entityName} attribute.
     * @param entityName The value for entityName 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entityName(String entityName) {
      this.entityName = Preconditions.checkNotNull(entityName, "entityName");
      initBits &= ~INIT_BIT_ENTITY_NAME;
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandToS3TestConfiguration#query() query} to query.
     * @param query The value for query
     * @return {@code this} builder for chained invocation
     */
    public final Builder query(String query) {
      this.query = Preconditions.checkNotNull(query, "query");
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandToS3TestConfiguration#query() query} to query.
     * @param query The value for query
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder query(Optional<String> query) {
      this.query = query.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandToS3TestConfiguration#flowTimeout() flowTimeout} to flowTimeout.
     * @param flowTimeout The value for flowTimeout
     * @return {@code this} builder for chained invocation
     */
    public final Builder flowTimeout(int flowTimeout) {
      this.flowTimeout = flowTimeout;
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandToS3TestConfiguration#flowTimeout() flowTimeout} to flowTimeout.
     * @param flowTimeout The value for flowTimeout
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder flowTimeout(Optional<Integer> flowTimeout) {
      this.flowTimeout = flowTimeout.orElse(null);
      return this;
    }

    /**
     * Adds one element to {@link OnDemandToS3TestConfiguration#entityFields() entityFields} list.
     * @param element A entityFields element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addEntityFields(String element) {
      this.entityFields.add(element);
      return this;
    }

    /**
     * Adds elements to {@link OnDemandToS3TestConfiguration#entityFields() entityFields} list.
     * @param elements An array of entityFields elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addEntityFields(String... elements) {
      this.entityFields.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link OnDemandToS3TestConfiguration#entityFields() entityFields} list.
     * @param elements An iterable of entityFields elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entityFields(Iterable<String> elements) {
      this.entityFields = ImmutableList.builder();
      return addAllEntityFields(elements);
    }

    /**
     * Adds elements to {@link OnDemandToS3TestConfiguration#entityFields() entityFields} list.
     * @param elements An iterable of entityFields elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllEntityFields(Iterable<String> elements) {
      this.entityFields.addAll(elements);
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandToS3TestConfiguration#outputSize() outputSize} to outputSize.
     * @param outputSize The value for outputSize
     * @return {@code this} builder for chained invocation
     */
    public final Builder outputSize(long outputSize) {
      this.outputSize = outputSize;
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandToS3TestConfiguration#outputSize() outputSize} to outputSize.
     * @param outputSize The value for outputSize
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder outputSize(Optional<Long> outputSize) {
      this.outputSize = outputSize.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandToS3TestConfiguration#sourceRuntimeProperties() sourceRuntimeProperties} to sourceRuntimeProperties.
     * @param sourceRuntimeProperties The value for sourceRuntimeProperties
     * @return {@code this} builder for chained invocation
     */
    public final Builder sourceRuntimeProperties(Map<String, String> sourceRuntimeProperties) {
      this.sourceRuntimeProperties = Preconditions.checkNotNull(sourceRuntimeProperties, "sourceRuntimeProperties");
      return this;
    }

    /**
     * Initializes the optional value {@link OnDemandToS3TestConfiguration#sourceRuntimeProperties() sourceRuntimeProperties} to sourceRuntimeProperties.
     * @param sourceRuntimeProperties The value for sourceRuntimeProperties
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder sourceRuntimeProperties(Optional<Map<String, String>> sourceRuntimeProperties) {
      this.sourceRuntimeProperties = sourceRuntimeProperties.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ImmutableOnDemandToS3TestConfiguration ImmutableOnDemandToS3TestConfiguration}.
     * @return An immutable instance of OnDemandToS3TestConfiguration
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableOnDemandToS3TestConfiguration build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableOnDemandToS3TestConfiguration(
          testName,
          apiVersion,
          profileName,
          flowName,
          entityName,
          query,
          flowTimeout,
          entityFields.build(),
          outputSize,
          sourceRuntimeProperties);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_FLOW_NAME) != 0) attributes.add("flowName");
      if ((initBits & INIT_BIT_ENTITY_NAME) != 0) attributes.add("entityName");
      return "Cannot build OnDemandToS3TestConfiguration, some of required attributes are not set " + attributes;
    }
  }
}
