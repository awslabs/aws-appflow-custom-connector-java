package com.amazonaws.appflow.custom.connector.model.settings;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.primitives.Booleans;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link ConnectorRuntimeSetting}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableConnectorRuntimeSetting.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableConnectorRuntimeSetting
    implements ConnectorRuntimeSetting {
  private final String key;
  private final ConnectorRuntimeSettingDataType dataType;
  private final boolean required;
  private final String label;
  private final String description;
  private final ConnectorRuntimeSettingScope scope;
  private final @Nullable ImmutableList<String> connectorSuppliedValueOptions;

  private ImmutableConnectorRuntimeSetting(
      String key,
      ConnectorRuntimeSettingDataType dataType,
      boolean required,
      String label,
      String description,
      ConnectorRuntimeSettingScope scope,
      @Nullable ImmutableList<String> connectorSuppliedValueOptions) {
    this.key = key;
    this.dataType = dataType;
    this.required = required;
    this.label = label;
    this.description = description;
    this.scope = scope;
    this.connectorSuppliedValueOptions = connectorSuppliedValueOptions;
  }

  /**
   * Unique identifier for the connector runtime setting.
   */
  @JsonProperty("key")
  @Override
  public String key() {
    return key;
  }

  /**
   * Data type for the connector runtime setting.
   */
  @JsonProperty("dataType")
  @Override
  public ConnectorRuntimeSettingDataType dataType() {
    return dataType;
  }

  /**
   * Specifies if this setting is required or not.
   */
  @JsonProperty("required")
  @Override
  public boolean required() {
    return required;
  }

  /**
   * Label for the connector runtime setting.
   */
  @JsonProperty("label")
  @Override
  public String label() {
    return label;
  }

  /**
   * Description of the connector runtime setting.
   */
  @JsonProperty("description")
  @Override
  public String description() {
    return description;
  }

  /**
   * Scope of the runtime setting needed for CONNECTOR_PROFILE, SOURCE, DESTINATION etc.
   */
  @JsonProperty("scope")
  @Override
  public ConnectorRuntimeSettingScope scope() {
    return scope;
  }

  /**
   * Optional connector supplied value options (with matching data type) that the user can pick from as a value for
   * this runtime setting.
   */
  @JsonProperty("connectorSuppliedValueOptions")
  @Override
  public @Nullable ImmutableList<String> connectorSuppliedValueOptions() {
    return connectorSuppliedValueOptions;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ConnectorRuntimeSetting#key() key} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param key A new value for key
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableConnectorRuntimeSetting withKey(String key) {
    if (this.key.equals(key)) return this;
    String newValue = Preconditions.checkNotNull(key, "key");
    return new ImmutableConnectorRuntimeSetting(
        newValue,
        this.dataType,
        this.required,
        this.label,
        this.description,
        this.scope,
        this.connectorSuppliedValueOptions);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ConnectorRuntimeSetting#dataType() dataType} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param dataType A new value for dataType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableConnectorRuntimeSetting withDataType(ConnectorRuntimeSettingDataType dataType) {
    if (this.dataType == dataType) return this;
    ConnectorRuntimeSettingDataType newValue = Preconditions.checkNotNull(dataType, "dataType");
    return new ImmutableConnectorRuntimeSetting(
        this.key,
        newValue,
        this.required,
        this.label,
        this.description,
        this.scope,
        this.connectorSuppliedValueOptions);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ConnectorRuntimeSetting#required() required} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param required A new value for required
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableConnectorRuntimeSetting withRequired(boolean required) {
    if (this.required == required) return this;
    return new ImmutableConnectorRuntimeSetting(
        this.key,
        this.dataType,
        required,
        this.label,
        this.description,
        this.scope,
        this.connectorSuppliedValueOptions);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ConnectorRuntimeSetting#label() label} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param label A new value for label
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableConnectorRuntimeSetting withLabel(String label) {
    if (this.label.equals(label)) return this;
    String newValue = Preconditions.checkNotNull(label, "label");
    return new ImmutableConnectorRuntimeSetting(
        this.key,
        this.dataType,
        this.required,
        newValue,
        this.description,
        this.scope,
        this.connectorSuppliedValueOptions);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ConnectorRuntimeSetting#description() description} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param description A new value for description
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableConnectorRuntimeSetting withDescription(String description) {
    if (this.description.equals(description)) return this;
    String newValue = Preconditions.checkNotNull(description, "description");
    return new ImmutableConnectorRuntimeSetting(
        this.key,
        this.dataType,
        this.required,
        this.label,
        newValue,
        this.scope,
        this.connectorSuppliedValueOptions);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ConnectorRuntimeSetting#scope() scope} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param scope A new value for scope
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableConnectorRuntimeSetting withScope(ConnectorRuntimeSettingScope scope) {
    if (this.scope == scope) return this;
    ConnectorRuntimeSettingScope newValue = Preconditions.checkNotNull(scope, "scope");
    return new ImmutableConnectorRuntimeSetting(
        this.key,
        this.dataType,
        this.required,
        this.label,
        this.description,
        newValue,
        this.connectorSuppliedValueOptions);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ConnectorRuntimeSetting#connectorSuppliedValueOptions() connectorSuppliedValueOptions}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableConnectorRuntimeSetting withConnectorSuppliedValueOptions(@Nullable String... elements) {
    if (elements == null) {
      return new ImmutableConnectorRuntimeSetting(this.key, this.dataType, this.required, this.label, this.description, this.scope, null);
    }
    @Nullable ImmutableList<String> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableConnectorRuntimeSetting(this.key, this.dataType, this.required, this.label, this.description, this.scope, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ConnectorRuntimeSetting#connectorSuppliedValueOptions() connectorSuppliedValueOptions}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of connectorSuppliedValueOptions elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableConnectorRuntimeSetting withConnectorSuppliedValueOptions(@Nullable Iterable<String> elements) {
    if (this.connectorSuppliedValueOptions == elements) return this;
    @Nullable ImmutableList<String> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableConnectorRuntimeSetting(this.key, this.dataType, this.required, this.label, this.description, this.scope, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableConnectorRuntimeSetting} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableConnectorRuntimeSetting
        && equalTo((ImmutableConnectorRuntimeSetting) another);
  }

  private boolean equalTo(ImmutableConnectorRuntimeSetting another) {
    return key.equals(another.key)
        && dataType.equals(another.dataType)
        && required == another.required
        && label.equals(another.label)
        && description.equals(another.description)
        && scope.equals(another.scope)
        && Objects.equal(connectorSuppliedValueOptions, another.connectorSuppliedValueOptions);
  }

  /**
   * Computes a hash code from attributes: {@code key}, {@code dataType}, {@code required}, {@code label}, {@code description}, {@code scope}, {@code connectorSuppliedValueOptions}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + key.hashCode();
    h = h * 17 + dataType.hashCode();
    h = h * 17 + Booleans.hashCode(required);
    h = h * 17 + label.hashCode();
    h = h * 17 + description.hashCode();
    h = h * 17 + scope.hashCode();
    h = h * 17 + Objects.hashCode(connectorSuppliedValueOptions);
    return h;
  }

  /**
   * Prints the immutable value {@code ConnectorRuntimeSetting} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ConnectorRuntimeSetting")
        .omitNullValues()
        .add("key", key)
        .add("dataType", dataType)
        .add("required", required)
        .add("label", label)
        .add("description", description)
        .add("scope", scope)
        .add("connectorSuppliedValueOptions", connectorSuppliedValueOptions)
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
      implements ConnectorRuntimeSetting {
    @Nullable String key;
    @Nullable ConnectorRuntimeSettingDataType dataType;
    boolean required;
    boolean requiredIsSet;
    @Nullable String label;
    @Nullable String description;
    @Nullable ConnectorRuntimeSettingScope scope;
    List<String> connectorSuppliedValueOptions = null;
    @JsonProperty("key")
    public void setKey(String key) {
      this.key = key;
    }
    @JsonProperty("dataType")
    public void setDataType(ConnectorRuntimeSettingDataType dataType) {
      this.dataType = dataType;
    }
    @JsonProperty("required")
    public void setRequired(boolean required) {
      this.required = required;
      this.requiredIsSet = true;
    }
    @JsonProperty("label")
    public void setLabel(String label) {
      this.label = label;
    }
    @JsonProperty("description")
    public void setDescription(String description) {
      this.description = description;
    }
    @JsonProperty("scope")
    public void setScope(ConnectorRuntimeSettingScope scope) {
      this.scope = scope;
    }
    @JsonProperty("connectorSuppliedValueOptions")
    public void setConnectorSuppliedValueOptions(@Nullable List<String> connectorSuppliedValueOptions) {
      this.connectorSuppliedValueOptions = connectorSuppliedValueOptions;
    }
    @Override
    public String key() { throw new UnsupportedOperationException(); }
    @Override
    public ConnectorRuntimeSettingDataType dataType() { throw new UnsupportedOperationException(); }
    @Override
    public boolean required() { throw new UnsupportedOperationException(); }
    @Override
    public String label() { throw new UnsupportedOperationException(); }
    @Override
    public String description() { throw new UnsupportedOperationException(); }
    @Override
    public ConnectorRuntimeSettingScope scope() { throw new UnsupportedOperationException(); }
    @Override
    public List<String> connectorSuppliedValueOptions() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableConnectorRuntimeSetting fromJson(Json json) {
    ImmutableConnectorRuntimeSetting.Builder builder = ImmutableConnectorRuntimeSetting.builder();
    if (json.key != null) {
      builder.key(json.key);
    }
    if (json.dataType != null) {
      builder.dataType(json.dataType);
    }
    if (json.requiredIsSet) {
      builder.required(json.required);
    }
    if (json.label != null) {
      builder.label(json.label);
    }
    if (json.description != null) {
      builder.description(json.description);
    }
    if (json.scope != null) {
      builder.scope(json.scope);
    }
    if (json.connectorSuppliedValueOptions != null) {
      builder.addAllConnectorSuppliedValueOptions(json.connectorSuppliedValueOptions);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link ConnectorRuntimeSetting} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ConnectorRuntimeSetting instance
   */
  public static ImmutableConnectorRuntimeSetting copyOf(ConnectorRuntimeSetting instance) {
    if (instance instanceof ImmutableConnectorRuntimeSetting) {
      return (ImmutableConnectorRuntimeSetting) instance;
    }
    return ImmutableConnectorRuntimeSetting.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableConnectorRuntimeSetting ImmutableConnectorRuntimeSetting}.
   * @return A new ImmutableConnectorRuntimeSetting builder
   */
  public static ImmutableConnectorRuntimeSetting.Builder builder() {
    return new ImmutableConnectorRuntimeSetting.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableConnectorRuntimeSetting ImmutableConnectorRuntimeSetting}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_KEY = 0x1L;
    private static final long INIT_BIT_DATA_TYPE = 0x2L;
    private static final long INIT_BIT_REQUIRED = 0x4L;
    private static final long INIT_BIT_LABEL = 0x8L;
    private static final long INIT_BIT_DESCRIPTION = 0x10L;
    private static final long INIT_BIT_SCOPE = 0x20L;
    private long initBits = 0x3fL;

    private @Nullable String key;
    private @Nullable ConnectorRuntimeSettingDataType dataType;
    private boolean required;
    private @Nullable String label;
    private @Nullable String description;
    private @Nullable ConnectorRuntimeSettingScope scope;
    private ImmutableList.Builder<String> connectorSuppliedValueOptions = null;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ConnectorRuntimeSetting} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ConnectorRuntimeSetting instance) {
      Preconditions.checkNotNull(instance, "instance");
      key(instance.key());
      dataType(instance.dataType());
      required(instance.required());
      label(instance.label());
      description(instance.description());
      scope(instance.scope());
      @Nullable List<String> connectorSuppliedValueOptionsValue = instance.connectorSuppliedValueOptions();
      if (connectorSuppliedValueOptionsValue != null) {
        addAllConnectorSuppliedValueOptions(connectorSuppliedValueOptionsValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link ConnectorRuntimeSetting#key() key} attribute.
     * @param key The value for key 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder key(String key) {
      this.key = Preconditions.checkNotNull(key, "key");
      initBits &= ~INIT_BIT_KEY;
      return this;
    }

    /**
     * Initializes the value for the {@link ConnectorRuntimeSetting#dataType() dataType} attribute.
     * @param dataType The value for dataType 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder dataType(ConnectorRuntimeSettingDataType dataType) {
      this.dataType = Preconditions.checkNotNull(dataType, "dataType");
      initBits &= ~INIT_BIT_DATA_TYPE;
      return this;
    }

    /**
     * Initializes the value for the {@link ConnectorRuntimeSetting#required() required} attribute.
     * @param required The value for required 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder required(boolean required) {
      this.required = required;
      initBits &= ~INIT_BIT_REQUIRED;
      return this;
    }

    /**
     * Initializes the value for the {@link ConnectorRuntimeSetting#label() label} attribute.
     * @param label The value for label 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder label(String label) {
      this.label = Preconditions.checkNotNull(label, "label");
      initBits &= ~INIT_BIT_LABEL;
      return this;
    }

    /**
     * Initializes the value for the {@link ConnectorRuntimeSetting#description() description} attribute.
     * @param description The value for description 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder description(String description) {
      this.description = Preconditions.checkNotNull(description, "description");
      initBits &= ~INIT_BIT_DESCRIPTION;
      return this;
    }

    /**
     * Initializes the value for the {@link ConnectorRuntimeSetting#scope() scope} attribute.
     * @param scope The value for scope 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder scope(ConnectorRuntimeSettingScope scope) {
      this.scope = Preconditions.checkNotNull(scope, "scope");
      initBits &= ~INIT_BIT_SCOPE;
      return this;
    }

    /**
     * Adds one element to {@link ConnectorRuntimeSetting#connectorSuppliedValueOptions() connectorSuppliedValueOptions} list.
     * @param element A connectorSuppliedValueOptions element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addConnectorSuppliedValueOptions(String element) {
      if (this.connectorSuppliedValueOptions == null) {
        this.connectorSuppliedValueOptions = ImmutableList.builder();
      }
      this.connectorSuppliedValueOptions.add(element);
      return this;
    }

    /**
     * Adds elements to {@link ConnectorRuntimeSetting#connectorSuppliedValueOptions() connectorSuppliedValueOptions} list.
     * @param elements An array of connectorSuppliedValueOptions elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addConnectorSuppliedValueOptions(String... elements) {
      if (this.connectorSuppliedValueOptions == null) {
        this.connectorSuppliedValueOptions = ImmutableList.builder();
      }
      this.connectorSuppliedValueOptions.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link ConnectorRuntimeSetting#connectorSuppliedValueOptions() connectorSuppliedValueOptions} list.
     * @param elements An iterable of connectorSuppliedValueOptions elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder connectorSuppliedValueOptions(@Nullable Iterable<String> elements) {
      if (elements == null) {
        this.connectorSuppliedValueOptions = null;
        return this;
      }
      this.connectorSuppliedValueOptions = ImmutableList.builder();
      return addAllConnectorSuppliedValueOptions(elements);
    }

    /**
     * Adds elements to {@link ConnectorRuntimeSetting#connectorSuppliedValueOptions() connectorSuppliedValueOptions} list.
     * @param elements An iterable of connectorSuppliedValueOptions elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllConnectorSuppliedValueOptions(Iterable<String> elements) {
      Preconditions.checkNotNull(elements, "connectorSuppliedValueOptions element");
      if (this.connectorSuppliedValueOptions == null) {
        this.connectorSuppliedValueOptions = ImmutableList.builder();
      }
      this.connectorSuppliedValueOptions.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutableConnectorRuntimeSetting ImmutableConnectorRuntimeSetting}.
     * @return An immutable instance of ConnectorRuntimeSetting
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableConnectorRuntimeSetting build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableConnectorRuntimeSetting(
          key,
          dataType,
          required,
          label,
          description,
          scope,
          connectorSuppliedValueOptions == null ? null : connectorSuppliedValueOptions.build());
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_KEY) != 0) attributes.add("key");
      if ((initBits & INIT_BIT_DATA_TYPE) != 0) attributes.add("dataType");
      if ((initBits & INIT_BIT_REQUIRED) != 0) attributes.add("required");
      if ((initBits & INIT_BIT_LABEL) != 0) attributes.add("label");
      if ((initBits & INIT_BIT_DESCRIPTION) != 0) attributes.add("description");
      if ((initBits & INIT_BIT_SCOPE) != 0) attributes.add("scope");
      return "Cannot build ConnectorRuntimeSetting, some of required attributes are not set " + attributes;
    }
  }
}
