package com.amazonaws.appflow.custom.connector.model.metadata;

import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.ConnectorOperator;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link FieldDefinition}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableFieldDefinition.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableFieldDefinition
    implements FieldDefinition {
  private final String fieldName;
  private final FieldDataType dataType;
  private final String dataTypeLabel;
  private final @Nullable String label;
  private final @Nullable String description;
  private final @Nullable Boolean isPrimaryKey;
  private final @Nullable String defaultValue;
  private final @Nullable Boolean isDeprecated;
  private final @Nullable FieldConstraints constraints;
  private final @Nullable ReadOperationProperty readProperties;
  private final @Nullable WriteOperationProperty writeProperties;
  private final ImmutableList<ConnectorOperator> filterOperators;
  private final @Nullable ImmutableMap<String, String> customProperties;

  private ImmutableFieldDefinition(ImmutableFieldDefinition.Builder builder) {
    this.fieldName = builder.fieldName;
    this.dataType = builder.dataType;
    this.label = builder.label;
    this.description = builder.description;
    this.isPrimaryKey = builder.isPrimaryKey;
    this.defaultValue = builder.defaultValue;
    this.isDeprecated = builder.isDeprecated;
    this.constraints = builder.constraints;
    this.readProperties = builder.readProperties;
    this.writeProperties = builder.writeProperties;
    this.customProperties = builder.customProperties == null ? null : builder.customProperties.build();
    if (builder.dataTypeLabel != null) {
      initShim.dataTypeLabel(builder.dataTypeLabel);
    }
    if (builder.filterOperatorsIsSet()) {
      initShim.filterOperators(builder.filterOperators.build());
    }
    this.dataTypeLabel = initShim.dataTypeLabel();
    this.filterOperators = initShim.filterOperators();
    this.initShim = null;
  }

  private ImmutableFieldDefinition(
      String fieldName,
      FieldDataType dataType,
      String dataTypeLabel,
      @Nullable String label,
      @Nullable String description,
      @Nullable Boolean isPrimaryKey,
      @Nullable String defaultValue,
      @Nullable Boolean isDeprecated,
      @Nullable FieldConstraints constraints,
      @Nullable ReadOperationProperty readProperties,
      @Nullable WriteOperationProperty writeProperties,
      ImmutableList<ConnectorOperator> filterOperators,
      @Nullable ImmutableMap<String, String> customProperties) {
    this.fieldName = fieldName;
    this.dataType = dataType;
    this.dataTypeLabel = dataTypeLabel;
    this.label = label;
    this.description = description;
    this.isPrimaryKey = isPrimaryKey;
    this.defaultValue = defaultValue;
    this.isDeprecated = isDeprecated;
    this.constraints = constraints;
    this.readProperties = readProperties;
    this.writeProperties = writeProperties;
    this.filterOperators = filterOperators;
    this.customProperties = customProperties;
    this.initShim = null;
  }

  private static final int STAGE_INITIALIZING = -1;
  private static final int STAGE_UNINITIALIZED = 0;
  private static final int STAGE_INITIALIZED = 1;
  private transient volatile InitShim initShim = new InitShim();

  private final class InitShim {
    private String dataTypeLabel;
    private int dataTypeLabelStage;

    String dataTypeLabel() {
      if (dataTypeLabelStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (dataTypeLabelStage == STAGE_UNINITIALIZED) {
        dataTypeLabelStage = STAGE_INITIALIZING;
        this.dataTypeLabel = Preconditions.checkNotNull(dataTypeLabelInitialize(), "dataTypeLabel");
        dataTypeLabelStage = STAGE_INITIALIZED;
      }
      return this.dataTypeLabel;
    }

    void dataTypeLabel(String dataTypeLabel) {
      this.dataTypeLabel = dataTypeLabel;
      dataTypeLabelStage = STAGE_INITIALIZED;
    }
    private ImmutableList<ConnectorOperator> filterOperators;
    private int filterOperatorsStage;

    ImmutableList<ConnectorOperator> filterOperators() {
      if (filterOperatorsStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (filterOperatorsStage == STAGE_UNINITIALIZED) {
        filterOperatorsStage = STAGE_INITIALIZING;
        this.filterOperators = ImmutableList.copyOf(filterOperatorsInitialize());
        filterOperatorsStage = STAGE_INITIALIZED;
      }
      return this.filterOperators;
    }

    void filterOperators(ImmutableList<ConnectorOperator> filterOperators) {
      this.filterOperators = filterOperators;
      filterOperatorsStage = STAGE_INITIALIZED;
    }

    private String formatInitCycleMessage() {
      ArrayList<String> attributes = Lists.newArrayList();
      if (dataTypeLabelStage == STAGE_INITIALIZING) attributes.add("dataTypeLabel");
      if (filterOperatorsStage == STAGE_INITIALIZING) attributes.add("filterOperators");
      return "Cannot build FieldDefinition, attribute initializers form cycle" + attributes;
    }
  }

  private String dataTypeLabelInitialize() {
    return FieldDefinition.super.dataTypeLabel();
  }

  private List<ConnectorOperator> filterOperatorsInitialize() {
    return FieldDefinition.super.filterOperators();
  }

  /**
   * The unique identifier of the connector field.
   */
  @JsonProperty("fieldName")
  @Override
  public String fieldName() {
    return fieldName;
  }

  /**
   * DataType of this field.
   */
  @JsonProperty("dataType")
  @Override
  public FieldDataType dataType() {
    return dataType;
  }

  /**
   * Application specific description of the dataType, so that AppFlow user can be presented with the same information
   * in the public API for exposing connector specific metadata
   */
  @JsonProperty("dataTypeLabel")
  @Override
  public String dataTypeLabel() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.dataTypeLabel()
        : this.dataTypeLabel;
  }

  /**
   * Label for this field.
   */
  @JsonProperty("label")
  @Override
  public @Nullable String label() {
    return label;
  }

  /**
   * Description of this field.
   */
  @JsonProperty("description")
  @Override
  public @Nullable String description() {
    return description;
  }

  /**
   * Specifies if it can be used as a primary key.
   */
  @JsonProperty("isPrimaryKey")
  @Override
  public @Nullable Boolean isPrimaryKey() {
    return isPrimaryKey;
  }

  /**
   * Default value of the field.
   */
  @JsonProperty("defaultValue")
  @Override
  public @Nullable String defaultValue() {
    return defaultValue;
  }

  /**
   * Specifies if this field is deprecated.
   */
  @JsonProperty("isDeprecated")
  @Override
  public @Nullable Boolean isDeprecated() {
    return isDeprecated;
  }

  /**
   * Constraints applicable to this field like length, value etc.
   */
  @JsonProperty("constraints")
  @Override
  public @Nullable FieldConstraints constraints() {
    return constraints;
  }

  /**
   * The properties that can be applied to a field when the connector is being used as a SOURCE.
   */
  @JsonProperty("readProperties")
  @Override
  public @Nullable ReadOperationProperty readProperties() {
    return readProperties;
  }

  /**
   * The properties applied to a field when the connector is being used as a destination.
   */
  @JsonProperty("writeProperties")
  @Override
  public @Nullable WriteOperationProperty writeProperties() {
    return writeProperties;
  }

  /**
   * Filter Operators applicable for this field. This method can be overridden by the connector developers for
   * specific use cases. For example if they wish to disallow certain operators for specific data types, that can be
   * modified by overriding this method.
   */
  @JsonProperty("filterOperators")
  @Override
  public ImmutableList<ConnectorOperator> filterOperators() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.filterOperators()
        : this.filterOperators;
  }

  /**
   * Custom properties defined for this field.
   */
  @JsonProperty("customProperties")
  @Override
  public @Nullable ImmutableMap<String, String> customProperties() {
    return customProperties;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link FieldDefinition#fieldName() fieldName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param fieldName A new value for fieldName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableFieldDefinition withFieldName(String fieldName) {
    if (this.fieldName.equals(fieldName)) return this;
    String newValue = Preconditions.checkNotNull(fieldName, "fieldName");
    return new ImmutableFieldDefinition(
        newValue,
        this.dataType,
        this.dataTypeLabel,
        this.label,
        this.description,
        this.isPrimaryKey,
        this.defaultValue,
        this.isDeprecated,
        this.constraints,
        this.readProperties,
        this.writeProperties,
        this.filterOperators,
        this.customProperties);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link FieldDefinition#dataType() dataType} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param dataType A new value for dataType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableFieldDefinition withDataType(FieldDataType dataType) {
    if (this.dataType == dataType) return this;
    FieldDataType newValue = Preconditions.checkNotNull(dataType, "dataType");
    return new ImmutableFieldDefinition(
        this.fieldName,
        newValue,
        this.dataTypeLabel,
        this.label,
        this.description,
        this.isPrimaryKey,
        this.defaultValue,
        this.isDeprecated,
        this.constraints,
        this.readProperties,
        this.writeProperties,
        this.filterOperators,
        this.customProperties);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link FieldDefinition#dataTypeLabel() dataTypeLabel} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param dataTypeLabel A new value for dataTypeLabel
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableFieldDefinition withDataTypeLabel(String dataTypeLabel) {
    if (this.dataTypeLabel.equals(dataTypeLabel)) return this;
    String newValue = Preconditions.checkNotNull(dataTypeLabel, "dataTypeLabel");
    return new ImmutableFieldDefinition(
        this.fieldName,
        this.dataType,
        newValue,
        this.label,
        this.description,
        this.isPrimaryKey,
        this.defaultValue,
        this.isDeprecated,
        this.constraints,
        this.readProperties,
        this.writeProperties,
        this.filterOperators,
        this.customProperties);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link FieldDefinition#label() label} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param label A new value for label (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableFieldDefinition withLabel(@Nullable String label) {
    if (Objects.equal(this.label, label)) return this;
    return new ImmutableFieldDefinition(
        this.fieldName,
        this.dataType,
        this.dataTypeLabel,
        label,
        this.description,
        this.isPrimaryKey,
        this.defaultValue,
        this.isDeprecated,
        this.constraints,
        this.readProperties,
        this.writeProperties,
        this.filterOperators,
        this.customProperties);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link FieldDefinition#description() description} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param description A new value for description (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableFieldDefinition withDescription(@Nullable String description) {
    if (Objects.equal(this.description, description)) return this;
    return new ImmutableFieldDefinition(
        this.fieldName,
        this.dataType,
        this.dataTypeLabel,
        this.label,
        description,
        this.isPrimaryKey,
        this.defaultValue,
        this.isDeprecated,
        this.constraints,
        this.readProperties,
        this.writeProperties,
        this.filterOperators,
        this.customProperties);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link FieldDefinition#isPrimaryKey() isPrimaryKey} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param isPrimaryKey A new value for isPrimaryKey (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableFieldDefinition withIsPrimaryKey(@Nullable Boolean isPrimaryKey) {
    if (Objects.equal(this.isPrimaryKey, isPrimaryKey)) return this;
    return new ImmutableFieldDefinition(
        this.fieldName,
        this.dataType,
        this.dataTypeLabel,
        this.label,
        this.description,
        isPrimaryKey,
        this.defaultValue,
        this.isDeprecated,
        this.constraints,
        this.readProperties,
        this.writeProperties,
        this.filterOperators,
        this.customProperties);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link FieldDefinition#defaultValue() defaultValue} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param defaultValue A new value for defaultValue (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableFieldDefinition withDefaultValue(@Nullable String defaultValue) {
    if (Objects.equal(this.defaultValue, defaultValue)) return this;
    return new ImmutableFieldDefinition(
        this.fieldName,
        this.dataType,
        this.dataTypeLabel,
        this.label,
        this.description,
        this.isPrimaryKey,
        defaultValue,
        this.isDeprecated,
        this.constraints,
        this.readProperties,
        this.writeProperties,
        this.filterOperators,
        this.customProperties);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link FieldDefinition#isDeprecated() isDeprecated} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param isDeprecated A new value for isDeprecated (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableFieldDefinition withIsDeprecated(@Nullable Boolean isDeprecated) {
    if (Objects.equal(this.isDeprecated, isDeprecated)) return this;
    return new ImmutableFieldDefinition(
        this.fieldName,
        this.dataType,
        this.dataTypeLabel,
        this.label,
        this.description,
        this.isPrimaryKey,
        this.defaultValue,
        isDeprecated,
        this.constraints,
        this.readProperties,
        this.writeProperties,
        this.filterOperators,
        this.customProperties);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link FieldDefinition#constraints() constraints} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param constraints A new value for constraints (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableFieldDefinition withConstraints(@Nullable FieldConstraints constraints) {
    if (this.constraints == constraints) return this;
    return new ImmutableFieldDefinition(
        this.fieldName,
        this.dataType,
        this.dataTypeLabel,
        this.label,
        this.description,
        this.isPrimaryKey,
        this.defaultValue,
        this.isDeprecated,
        constraints,
        this.readProperties,
        this.writeProperties,
        this.filterOperators,
        this.customProperties);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link FieldDefinition#readProperties() readProperties} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param readProperties A new value for readProperties (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableFieldDefinition withReadProperties(@Nullable ReadOperationProperty readProperties) {
    if (this.readProperties == readProperties) return this;
    return new ImmutableFieldDefinition(
        this.fieldName,
        this.dataType,
        this.dataTypeLabel,
        this.label,
        this.description,
        this.isPrimaryKey,
        this.defaultValue,
        this.isDeprecated,
        this.constraints,
        readProperties,
        this.writeProperties,
        this.filterOperators,
        this.customProperties);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link FieldDefinition#writeProperties() writeProperties} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param writeProperties A new value for writeProperties (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableFieldDefinition withWriteProperties(@Nullable WriteOperationProperty writeProperties) {
    if (this.writeProperties == writeProperties) return this;
    return new ImmutableFieldDefinition(
        this.fieldName,
        this.dataType,
        this.dataTypeLabel,
        this.label,
        this.description,
        this.isPrimaryKey,
        this.defaultValue,
        this.isDeprecated,
        this.constraints,
        this.readProperties,
        writeProperties,
        this.filterOperators,
        this.customProperties);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link FieldDefinition#filterOperators() filterOperators}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableFieldDefinition withFilterOperators(ConnectorOperator... elements) {
    ImmutableList<ConnectorOperator> newValue = ImmutableList.copyOf(elements);
    return new ImmutableFieldDefinition(
        this.fieldName,
        this.dataType,
        this.dataTypeLabel,
        this.label,
        this.description,
        this.isPrimaryKey,
        this.defaultValue,
        this.isDeprecated,
        this.constraints,
        this.readProperties,
        this.writeProperties,
        newValue,
        this.customProperties);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link FieldDefinition#filterOperators() filterOperators}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of filterOperators elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableFieldDefinition withFilterOperators(Iterable<? extends ConnectorOperator> elements) {
    if (this.filterOperators == elements) return this;
    ImmutableList<ConnectorOperator> newValue = ImmutableList.copyOf(elements);
    return new ImmutableFieldDefinition(
        this.fieldName,
        this.dataType,
        this.dataTypeLabel,
        this.label,
        this.description,
        this.isPrimaryKey,
        this.defaultValue,
        this.isDeprecated,
        this.constraints,
        this.readProperties,
        this.writeProperties,
        newValue,
        this.customProperties);
  }

  /**
   * Copy the current immutable object by replacing the {@link FieldDefinition#customProperties() customProperties} map with the specified map.
   * Nulls are not permitted as keys or values.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param customProperties The entries to be added to the customProperties map
   * @return A modified copy of {@code this} object
   */
  public final ImmutableFieldDefinition withCustomProperties(@Nullable Map<String, ? extends String> customProperties) {
    if (this.customProperties == customProperties) return this;
    @Nullable ImmutableMap<String, String> newValue = customProperties == null ? null : ImmutableMap.copyOf(customProperties);
    return new ImmutableFieldDefinition(
        this.fieldName,
        this.dataType,
        this.dataTypeLabel,
        this.label,
        this.description,
        this.isPrimaryKey,
        this.defaultValue,
        this.isDeprecated,
        this.constraints,
        this.readProperties,
        this.writeProperties,
        this.filterOperators,
        newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableFieldDefinition} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableFieldDefinition
        && equalTo((ImmutableFieldDefinition) another);
  }

  private boolean equalTo(ImmutableFieldDefinition another) {
    return fieldName.equals(another.fieldName)
        && dataType.equals(another.dataType)
        && dataTypeLabel.equals(another.dataTypeLabel)
        && Objects.equal(label, another.label)
        && Objects.equal(description, another.description)
        && Objects.equal(isPrimaryKey, another.isPrimaryKey)
        && Objects.equal(defaultValue, another.defaultValue)
        && Objects.equal(isDeprecated, another.isDeprecated)
        && Objects.equal(constraints, another.constraints)
        && Objects.equal(readProperties, another.readProperties)
        && Objects.equal(writeProperties, another.writeProperties)
        && filterOperators.equals(another.filterOperators)
        && Objects.equal(customProperties, another.customProperties);
  }

  /**
   * Computes a hash code from attributes: {@code fieldName}, {@code dataType}, {@code dataTypeLabel}, {@code label}, {@code description}, {@code isPrimaryKey}, {@code defaultValue}, {@code isDeprecated}, {@code constraints}, {@code readProperties}, {@code writeProperties}, {@code filterOperators}, {@code customProperties}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + fieldName.hashCode();
    h = h * 17 + dataType.hashCode();
    h = h * 17 + dataTypeLabel.hashCode();
    h = h * 17 + Objects.hashCode(label);
    h = h * 17 + Objects.hashCode(description);
    h = h * 17 + Objects.hashCode(isPrimaryKey);
    h = h * 17 + Objects.hashCode(defaultValue);
    h = h * 17 + Objects.hashCode(isDeprecated);
    h = h * 17 + Objects.hashCode(constraints);
    h = h * 17 + Objects.hashCode(readProperties);
    h = h * 17 + Objects.hashCode(writeProperties);
    h = h * 17 + filterOperators.hashCode();
    h = h * 17 + Objects.hashCode(customProperties);
    return h;
  }

  /**
   * Prints the immutable value {@code FieldDefinition} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("FieldDefinition")
        .omitNullValues()
        .add("fieldName", fieldName)
        .add("dataType", dataType)
        .add("dataTypeLabel", dataTypeLabel)
        .add("label", label)
        .add("description", description)
        .add("isPrimaryKey", isPrimaryKey)
        .add("defaultValue", defaultValue)
        .add("isDeprecated", isDeprecated)
        .add("constraints", constraints)
        .add("readProperties", readProperties)
        .add("writeProperties", writeProperties)
        .add("filterOperators", filterOperators)
        .add("customProperties", customProperties)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements FieldDefinition {
    @Nullable String fieldName;
    @Nullable FieldDataType dataType;
    @Nullable String dataTypeLabel;
    @Nullable String label;
    @Nullable String description;
    @Nullable Boolean isPrimaryKey;
    @Nullable String defaultValue;
    @Nullable Boolean isDeprecated;
    @Nullable FieldConstraints constraints;
    @Nullable ReadOperationProperty readProperties;
    @Nullable WriteOperationProperty writeProperties;
    List<ConnectorOperator> filterOperators = ImmutableList.of();
    boolean filterOperatorsIsSet;
    @Nullable Map<String, String> customProperties;
    @JsonProperty("fieldName")
    public void setFieldName(String fieldName) {
      this.fieldName = fieldName;
    }
    @JsonProperty("dataType")
    public void setDataType(FieldDataType dataType) {
      this.dataType = dataType;
    }
    @JsonProperty("dataTypeLabel")
    public void setDataTypeLabel(String dataTypeLabel) {
      this.dataTypeLabel = dataTypeLabel;
    }
    @JsonProperty("label")
    public void setLabel(@Nullable String label) {
      this.label = label;
    }
    @JsonProperty("description")
    public void setDescription(@Nullable String description) {
      this.description = description;
    }
    @JsonProperty("isPrimaryKey")
    public void setIsPrimaryKey(@Nullable Boolean isPrimaryKey) {
      this.isPrimaryKey = isPrimaryKey;
    }
    @JsonProperty("defaultValue")
    public void setDefaultValue(@Nullable String defaultValue) {
      this.defaultValue = defaultValue;
    }
    @JsonProperty("isDeprecated")
    public void setIsDeprecated(@Nullable Boolean isDeprecated) {
      this.isDeprecated = isDeprecated;
    }
    @JsonProperty("constraints")
    public void setConstraints(@Nullable FieldConstraints constraints) {
      this.constraints = constraints;
    }
    @JsonProperty("readProperties")
    public void setReadProperties(@Nullable ReadOperationProperty readProperties) {
      this.readProperties = readProperties;
    }
    @JsonProperty("writeProperties")
    public void setWriteProperties(@Nullable WriteOperationProperty writeProperties) {
      this.writeProperties = writeProperties;
    }
    @JsonProperty("filterOperators")
    public void setFilterOperators(List<ConnectorOperator> filterOperators) {
      this.filterOperators = filterOperators;
      this.filterOperatorsIsSet = true;
    }
    @JsonProperty("customProperties")
    public void setCustomProperties(@Nullable Map<String, String> customProperties) {
      this.customProperties = customProperties;
    }
    @Override
    public String fieldName() { throw new UnsupportedOperationException(); }
    @Override
    public FieldDataType dataType() { throw new UnsupportedOperationException(); }
    @Override
    public String dataTypeLabel() { throw new UnsupportedOperationException(); }
    @Override
    public String label() { throw new UnsupportedOperationException(); }
    @Override
    public String description() { throw new UnsupportedOperationException(); }
    @Override
    public Boolean isPrimaryKey() { throw new UnsupportedOperationException(); }
    @Override
    public String defaultValue() { throw new UnsupportedOperationException(); }
    @Override
    public Boolean isDeprecated() { throw new UnsupportedOperationException(); }
    @Override
    public FieldConstraints constraints() { throw new UnsupportedOperationException(); }
    @Override
    public ReadOperationProperty readProperties() { throw new UnsupportedOperationException(); }
    @Override
    public WriteOperationProperty writeProperties() { throw new UnsupportedOperationException(); }
    @Override
    public List<ConnectorOperator> filterOperators() { throw new UnsupportedOperationException(); }
    @Override
    public Map<String, String> customProperties() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableFieldDefinition fromJson(Json json) {
    ImmutableFieldDefinition.Builder builder = ImmutableFieldDefinition.builder();
    if (json.fieldName != null) {
      builder.fieldName(json.fieldName);
    }
    if (json.dataType != null) {
      builder.dataType(json.dataType);
    }
    if (json.dataTypeLabel != null) {
      builder.dataTypeLabel(json.dataTypeLabel);
    }
    if (json.label != null) {
      builder.label(json.label);
    }
    if (json.description != null) {
      builder.description(json.description);
    }
    if (json.isPrimaryKey != null) {
      builder.isPrimaryKey(json.isPrimaryKey);
    }
    if (json.defaultValue != null) {
      builder.defaultValue(json.defaultValue);
    }
    if (json.isDeprecated != null) {
      builder.isDeprecated(json.isDeprecated);
    }
    if (json.constraints != null) {
      builder.constraints(json.constraints);
    }
    if (json.readProperties != null) {
      builder.readProperties(json.readProperties);
    }
    if (json.writeProperties != null) {
      builder.writeProperties(json.writeProperties);
    }
    if (json.filterOperatorsIsSet) {
      builder.filterOperators(json.filterOperators);
    }
    if (json.customProperties != null) {
      builder.putAllCustomProperties(json.customProperties);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link FieldDefinition} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable FieldDefinition instance
   */
  public static ImmutableFieldDefinition copyOf(FieldDefinition instance) {
    if (instance instanceof ImmutableFieldDefinition) {
      return (ImmutableFieldDefinition) instance;
    }
    return ImmutableFieldDefinition.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableFieldDefinition ImmutableFieldDefinition}.
   * @return A new ImmutableFieldDefinition builder
   */
  public static ImmutableFieldDefinition.Builder builder() {
    return new ImmutableFieldDefinition.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableFieldDefinition ImmutableFieldDefinition}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_FIELD_NAME = 0x1L;
    private static final long INIT_BIT_DATA_TYPE = 0x2L;
    private static final long OPT_BIT_FILTER_OPERATORS = 0x1L;
    private long initBits = 0x3L;
    private long optBits;

    private @Nullable String fieldName;
    private @Nullable FieldDataType dataType;
    private @Nullable String dataTypeLabel;
    private @Nullable String label;
    private @Nullable String description;
    private @Nullable Boolean isPrimaryKey;
    private @Nullable String defaultValue;
    private @Nullable Boolean isDeprecated;
    private @Nullable FieldConstraints constraints;
    private @Nullable ReadOperationProperty readProperties;
    private @Nullable WriteOperationProperty writeProperties;
    private ImmutableList.Builder<ConnectorOperator> filterOperators = ImmutableList.builder();
    private ImmutableMap.Builder<String, String> customProperties = null;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code FieldDefinition} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(FieldDefinition instance) {
      Preconditions.checkNotNull(instance, "instance");
      fieldName(instance.fieldName());
      dataType(instance.dataType());
      dataTypeLabel(instance.dataTypeLabel());
      @Nullable String labelValue = instance.label();
      if (labelValue != null) {
        label(labelValue);
      }
      @Nullable String descriptionValue = instance.description();
      if (descriptionValue != null) {
        description(descriptionValue);
      }
      @Nullable Boolean isPrimaryKeyValue = instance.isPrimaryKey();
      if (isPrimaryKeyValue != null) {
        isPrimaryKey(isPrimaryKeyValue);
      }
      @Nullable String defaultValueValue = instance.defaultValue();
      if (defaultValueValue != null) {
        defaultValue(defaultValueValue);
      }
      @Nullable Boolean isDeprecatedValue = instance.isDeprecated();
      if (isDeprecatedValue != null) {
        isDeprecated(isDeprecatedValue);
      }
      @Nullable FieldConstraints constraintsValue = instance.constraints();
      if (constraintsValue != null) {
        constraints(constraintsValue);
      }
      @Nullable ReadOperationProperty readPropertiesValue = instance.readProperties();
      if (readPropertiesValue != null) {
        readProperties(readPropertiesValue);
      }
      @Nullable WriteOperationProperty writePropertiesValue = instance.writeProperties();
      if (writePropertiesValue != null) {
        writeProperties(writePropertiesValue);
      }
      addAllFilterOperators(instance.filterOperators());
      @Nullable Map<String, String> customPropertiesValue = instance.customProperties();
      if (customPropertiesValue != null) {
        putAllCustomProperties(customPropertiesValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link FieldDefinition#fieldName() fieldName} attribute.
     * @param fieldName The value for fieldName 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder fieldName(String fieldName) {
      this.fieldName = Preconditions.checkNotNull(fieldName, "fieldName");
      initBits &= ~INIT_BIT_FIELD_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link FieldDefinition#dataType() dataType} attribute.
     * @param dataType The value for dataType 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder dataType(FieldDataType dataType) {
      this.dataType = Preconditions.checkNotNull(dataType, "dataType");
      initBits &= ~INIT_BIT_DATA_TYPE;
      return this;
    }

    /**
     * Initializes the value for the {@link FieldDefinition#dataTypeLabel() dataTypeLabel} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link FieldDefinition#dataTypeLabel() dataTypeLabel}.</em>
     * @param dataTypeLabel The value for dataTypeLabel 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder dataTypeLabel(String dataTypeLabel) {
      this.dataTypeLabel = Preconditions.checkNotNull(dataTypeLabel, "dataTypeLabel");
      return this;
    }

    /**
     * Initializes the value for the {@link FieldDefinition#label() label} attribute.
     * @param label The value for label (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder label(@Nullable String label) {
      this.label = label;
      return this;
    }

    /**
     * Initializes the value for the {@link FieldDefinition#description() description} attribute.
     * @param description The value for description (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder description(@Nullable String description) {
      this.description = description;
      return this;
    }

    /**
     * Initializes the value for the {@link FieldDefinition#isPrimaryKey() isPrimaryKey} attribute.
     * @param isPrimaryKey The value for isPrimaryKey (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isPrimaryKey(@Nullable Boolean isPrimaryKey) {
      this.isPrimaryKey = isPrimaryKey;
      return this;
    }

    /**
     * Initializes the value for the {@link FieldDefinition#defaultValue() defaultValue} attribute.
     * @param defaultValue The value for defaultValue (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder defaultValue(@Nullable String defaultValue) {
      this.defaultValue = defaultValue;
      return this;
    }

    /**
     * Initializes the value for the {@link FieldDefinition#isDeprecated() isDeprecated} attribute.
     * @param isDeprecated The value for isDeprecated (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isDeprecated(@Nullable Boolean isDeprecated) {
      this.isDeprecated = isDeprecated;
      return this;
    }

    /**
     * Initializes the value for the {@link FieldDefinition#constraints() constraints} attribute.
     * @param constraints The value for constraints (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder constraints(@Nullable FieldConstraints constraints) {
      this.constraints = constraints;
      return this;
    }

    /**
     * Initializes the value for the {@link FieldDefinition#readProperties() readProperties} attribute.
     * @param readProperties The value for readProperties (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder readProperties(@Nullable ReadOperationProperty readProperties) {
      this.readProperties = readProperties;
      return this;
    }

    /**
     * Initializes the value for the {@link FieldDefinition#writeProperties() writeProperties} attribute.
     * @param writeProperties The value for writeProperties (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder writeProperties(@Nullable WriteOperationProperty writeProperties) {
      this.writeProperties = writeProperties;
      return this;
    }

    /**
     * Adds one element to {@link FieldDefinition#filterOperators() filterOperators} list.
     * @param element A filterOperators element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addFilterOperators(ConnectorOperator element) {
      this.filterOperators.add(element);
      optBits |= OPT_BIT_FILTER_OPERATORS;
      return this;
    }

    /**
     * Adds elements to {@link FieldDefinition#filterOperators() filterOperators} list.
     * @param elements An array of filterOperators elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addFilterOperators(ConnectorOperator... elements) {
      this.filterOperators.add(elements);
      optBits |= OPT_BIT_FILTER_OPERATORS;
      return this;
    }

    /**
     * Sets or replaces all elements for {@link FieldDefinition#filterOperators() filterOperators} list.
     * @param elements An iterable of filterOperators elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder filterOperators(Iterable<? extends ConnectorOperator> elements) {
      this.filterOperators = ImmutableList.builder();
      return addAllFilterOperators(elements);
    }

    /**
     * Adds elements to {@link FieldDefinition#filterOperators() filterOperators} list.
     * @param elements An iterable of filterOperators elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllFilterOperators(Iterable<? extends ConnectorOperator> elements) {
      this.filterOperators.addAll(elements);
      optBits |= OPT_BIT_FILTER_OPERATORS;
      return this;
    }

    /**
     * Put one entry to the {@link FieldDefinition#customProperties() customProperties} map.
     * @param key The key in the customProperties map
     * @param value The associated value in the customProperties map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putCustomProperties(String key, String value) {
      if (this.customProperties == null) {
        this.customProperties = ImmutableMap.builder();
      }
      this.customProperties.put(key, value);
      return this;
    }

    /**
     * Put one entry to the {@link FieldDefinition#customProperties() customProperties} map. Nulls are not permitted
     * @param entry The key and value entry
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putCustomProperties(Map.Entry<String, ? extends String> entry) {
      if (this.customProperties == null) {
        this.customProperties = ImmutableMap.builder();
      }
      this.customProperties.put(entry);
      return this;
    }

    /**
     * Sets or replaces all mappings from the specified map as entries for the {@link FieldDefinition#customProperties() customProperties} map. Nulls are not permitted as keys or values, but parameter itself can be null
     * @param customProperties The entries that will be added to the customProperties map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder customProperties(@Nullable Map<String, ? extends String> customProperties) {
      if (customProperties == null) {
        this.customProperties = null;
        return this;
      }
      this.customProperties = ImmutableMap.builder();
      return putAllCustomProperties(customProperties);
    }

    /**
     * Put all mappings from the specified map as entries to {@link FieldDefinition#customProperties() customProperties} map. Nulls are not permitted
     * @param customProperties The entries that will be added to the customProperties map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putAllCustomProperties(Map<String, ? extends String> customProperties) {
      if (this.customProperties == null) {
        this.customProperties = ImmutableMap.builder();
      }
      this.customProperties.putAll(customProperties);
      return this;
    }

    /**
     * Builds a new {@link ImmutableFieldDefinition ImmutableFieldDefinition}.
     * @return An immutable instance of FieldDefinition
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableFieldDefinition build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableFieldDefinition(this);
    }

    private boolean filterOperatorsIsSet() {
      return (optBits & OPT_BIT_FILTER_OPERATORS) != 0;
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_FIELD_NAME) != 0) attributes.add("fieldName");
      if ((initBits & INIT_BIT_DATA_TYPE) != 0) attributes.add("dataType");
      return "Cannot build FieldDefinition, some of required attributes are not set " + attributes;
    }
  }
}
