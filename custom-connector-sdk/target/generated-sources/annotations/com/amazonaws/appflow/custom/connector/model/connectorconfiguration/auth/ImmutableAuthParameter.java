package com.amazonaws.appflow.custom.connector.model.connectorconfiguration.auth;

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
 * Immutable implementation of {@link AuthParameter}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableAuthParameter.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableAuthParameter
    implements AuthParameter {
  private final String key;
  private final boolean required;
  private final String label;
  private final String description;
  private final @Nullable Boolean sensitiveField;
  private final @Nullable ImmutableList<String> connectorSuppliedValues;

  private ImmutableAuthParameter(
      String key,
      boolean required,
      String label,
      String description,
      @Nullable Boolean sensitiveField,
      @Nullable ImmutableList<String> connectorSuppliedValues) {
    this.key = key;
    this.required = required;
    this.label = label;
    this.description = description;
    this.sensitiveField = sensitiveField;
    this.connectorSuppliedValues = connectorSuppliedValues;
  }

  /**
   * Unique identifier for AuthParameter.
   */
  @JsonProperty("key")
  @Override
  public String key() {
    return key;
  }

  /**
   * Specifies if this AuthParameter is required or not.
   */
  @JsonProperty("required")
  @Override
  public boolean required() {
    return required;
  }

  /**
   * Label of the Auth Parameter.
   */
  @JsonProperty("label")
  @Override
  public String label() {
    return label;
  }

  /**
   * Description of the Auth Parameter.
   */
  @JsonProperty("description")
  @Override
  public String description() {
    return description;
  }

  /**
   * Specifies if this field data is sensitive/Critical that shouldn't be stored as plain text.
   */
  @JsonProperty("sensitiveField")
  @Override
  public @Nullable Boolean sensitiveField() {
    return sensitiveField;
  }

  /**
   * Values provided by connector which can be used as input for this AuthParameter.
   */
  @JsonProperty("connectorSuppliedValues")
  @Override
  public @Nullable ImmutableList<String> connectorSuppliedValues() {
    return connectorSuppliedValues;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AuthParameter#key() key} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param key A new value for key
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAuthParameter withKey(String key) {
    if (this.key.equals(key)) return this;
    String newValue = Preconditions.checkNotNull(key, "key");
    return new ImmutableAuthParameter(
        newValue,
        this.required,
        this.label,
        this.description,
        this.sensitiveField,
        this.connectorSuppliedValues);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AuthParameter#required() required} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param required A new value for required
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAuthParameter withRequired(boolean required) {
    if (this.required == required) return this;
    return new ImmutableAuthParameter(
        this.key,
        required,
        this.label,
        this.description,
        this.sensitiveField,
        this.connectorSuppliedValues);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AuthParameter#label() label} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param label A new value for label
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAuthParameter withLabel(String label) {
    if (this.label.equals(label)) return this;
    String newValue = Preconditions.checkNotNull(label, "label");
    return new ImmutableAuthParameter(
        this.key,
        this.required,
        newValue,
        this.description,
        this.sensitiveField,
        this.connectorSuppliedValues);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AuthParameter#description() description} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param description A new value for description
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAuthParameter withDescription(String description) {
    if (this.description.equals(description)) return this;
    String newValue = Preconditions.checkNotNull(description, "description");
    return new ImmutableAuthParameter(
        this.key,
        this.required,
        this.label,
        newValue,
        this.sensitiveField,
        this.connectorSuppliedValues);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AuthParameter#sensitiveField() sensitiveField} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param sensitiveField A new value for sensitiveField (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAuthParameter withSensitiveField(@Nullable Boolean sensitiveField) {
    if (Objects.equal(this.sensitiveField, sensitiveField)) return this;
    return new ImmutableAuthParameter(
        this.key,
        this.required,
        this.label,
        this.description,
        sensitiveField,
        this.connectorSuppliedValues);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link AuthParameter#connectorSuppliedValues() connectorSuppliedValues}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableAuthParameter withConnectorSuppliedValues(@Nullable String... elements) {
    if (elements == null) {
      return new ImmutableAuthParameter(this.key, this.required, this.label, this.description, this.sensitiveField, null);
    }
    @Nullable ImmutableList<String> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableAuthParameter(this.key, this.required, this.label, this.description, this.sensitiveField, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link AuthParameter#connectorSuppliedValues() connectorSuppliedValues}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of connectorSuppliedValues elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableAuthParameter withConnectorSuppliedValues(@Nullable Iterable<String> elements) {
    if (this.connectorSuppliedValues == elements) return this;
    @Nullable ImmutableList<String> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableAuthParameter(this.key, this.required, this.label, this.description, this.sensitiveField, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableAuthParameter} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableAuthParameter
        && equalTo((ImmutableAuthParameter) another);
  }

  private boolean equalTo(ImmutableAuthParameter another) {
    return key.equals(another.key)
        && required == another.required
        && label.equals(another.label)
        && description.equals(another.description)
        && Objects.equal(sensitiveField, another.sensitiveField)
        && Objects.equal(connectorSuppliedValues, another.connectorSuppliedValues);
  }

  /**
   * Computes a hash code from attributes: {@code key}, {@code required}, {@code label}, {@code description}, {@code sensitiveField}, {@code connectorSuppliedValues}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + key.hashCode();
    h = h * 17 + Booleans.hashCode(required);
    h = h * 17 + label.hashCode();
    h = h * 17 + description.hashCode();
    h = h * 17 + Objects.hashCode(sensitiveField);
    h = h * 17 + Objects.hashCode(connectorSuppliedValues);
    return h;
  }

  /**
   * Prints the immutable value {@code AuthParameter} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("AuthParameter")
        .omitNullValues()
        .add("key", key)
        .add("required", required)
        .add("label", label)
        .add("description", description)
        .add("sensitiveField", sensitiveField)
        .add("connectorSuppliedValues", connectorSuppliedValues)
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
      implements AuthParameter {
    @Nullable String key;
    boolean required;
    boolean requiredIsSet;
    @Nullable String label;
    @Nullable String description;
    @Nullable Boolean sensitiveField;
    List<String> connectorSuppliedValues = null;
    @JsonProperty("key")
    public void setKey(String key) {
      this.key = key;
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
    @JsonProperty("sensitiveField")
    public void setSensitiveField(@Nullable Boolean sensitiveField) {
      this.sensitiveField = sensitiveField;
    }
    @JsonProperty("connectorSuppliedValues")
    public void setConnectorSuppliedValues(@Nullable List<String> connectorSuppliedValues) {
      this.connectorSuppliedValues = connectorSuppliedValues;
    }
    @Override
    public String key() { throw new UnsupportedOperationException(); }
    @Override
    public boolean required() { throw new UnsupportedOperationException(); }
    @Override
    public String label() { throw new UnsupportedOperationException(); }
    @Override
    public String description() { throw new UnsupportedOperationException(); }
    @Override
    public Boolean sensitiveField() { throw new UnsupportedOperationException(); }
    @Override
    public List<String> connectorSuppliedValues() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableAuthParameter fromJson(Json json) {
    ImmutableAuthParameter.Builder builder = ImmutableAuthParameter.builder();
    if (json.key != null) {
      builder.key(json.key);
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
    if (json.sensitiveField != null) {
      builder.sensitiveField(json.sensitiveField);
    }
    if (json.connectorSuppliedValues != null) {
      builder.addAllConnectorSuppliedValues(json.connectorSuppliedValues);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link AuthParameter} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable AuthParameter instance
   */
  public static ImmutableAuthParameter copyOf(AuthParameter instance) {
    if (instance instanceof ImmutableAuthParameter) {
      return (ImmutableAuthParameter) instance;
    }
    return ImmutableAuthParameter.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableAuthParameter ImmutableAuthParameter}.
   * @return A new ImmutableAuthParameter builder
   */
  public static ImmutableAuthParameter.Builder builder() {
    return new ImmutableAuthParameter.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableAuthParameter ImmutableAuthParameter}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_KEY = 0x1L;
    private static final long INIT_BIT_REQUIRED = 0x2L;
    private static final long INIT_BIT_LABEL = 0x4L;
    private static final long INIT_BIT_DESCRIPTION = 0x8L;
    private long initBits = 0xfL;

    private @Nullable String key;
    private boolean required;
    private @Nullable String label;
    private @Nullable String description;
    private @Nullable Boolean sensitiveField;
    private ImmutableList.Builder<String> connectorSuppliedValues = null;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code AuthParameter} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(AuthParameter instance) {
      Preconditions.checkNotNull(instance, "instance");
      key(instance.key());
      required(instance.required());
      label(instance.label());
      description(instance.description());
      @Nullable Boolean sensitiveFieldValue = instance.sensitiveField();
      if (sensitiveFieldValue != null) {
        sensitiveField(sensitiveFieldValue);
      }
      @Nullable List<String> connectorSuppliedValuesValue = instance.connectorSuppliedValues();
      if (connectorSuppliedValuesValue != null) {
        addAllConnectorSuppliedValues(connectorSuppliedValuesValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link AuthParameter#key() key} attribute.
     * @param key The value for key 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder key(String key) {
      this.key = Preconditions.checkNotNull(key, "key");
      initBits &= ~INIT_BIT_KEY;
      return this;
    }

    /**
     * Initializes the value for the {@link AuthParameter#required() required} attribute.
     * @param required The value for required 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder required(boolean required) {
      this.required = required;
      initBits &= ~INIT_BIT_REQUIRED;
      return this;
    }

    /**
     * Initializes the value for the {@link AuthParameter#label() label} attribute.
     * @param label The value for label 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder label(String label) {
      this.label = Preconditions.checkNotNull(label, "label");
      initBits &= ~INIT_BIT_LABEL;
      return this;
    }

    /**
     * Initializes the value for the {@link AuthParameter#description() description} attribute.
     * @param description The value for description 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder description(String description) {
      this.description = Preconditions.checkNotNull(description, "description");
      initBits &= ~INIT_BIT_DESCRIPTION;
      return this;
    }

    /**
     * Initializes the value for the {@link AuthParameter#sensitiveField() sensitiveField} attribute.
     * @param sensitiveField The value for sensitiveField (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder sensitiveField(@Nullable Boolean sensitiveField) {
      this.sensitiveField = sensitiveField;
      return this;
    }

    /**
     * Adds one element to {@link AuthParameter#connectorSuppliedValues() connectorSuppliedValues} list.
     * @param element A connectorSuppliedValues element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addConnectorSuppliedValues(String element) {
      if (this.connectorSuppliedValues == null) {
        this.connectorSuppliedValues = ImmutableList.builder();
      }
      this.connectorSuppliedValues.add(element);
      return this;
    }

    /**
     * Adds elements to {@link AuthParameter#connectorSuppliedValues() connectorSuppliedValues} list.
     * @param elements An array of connectorSuppliedValues elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addConnectorSuppliedValues(String... elements) {
      if (this.connectorSuppliedValues == null) {
        this.connectorSuppliedValues = ImmutableList.builder();
      }
      this.connectorSuppliedValues.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link AuthParameter#connectorSuppliedValues() connectorSuppliedValues} list.
     * @param elements An iterable of connectorSuppliedValues elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder connectorSuppliedValues(@Nullable Iterable<String> elements) {
      if (elements == null) {
        this.connectorSuppliedValues = null;
        return this;
      }
      this.connectorSuppliedValues = ImmutableList.builder();
      return addAllConnectorSuppliedValues(elements);
    }

    /**
     * Adds elements to {@link AuthParameter#connectorSuppliedValues() connectorSuppliedValues} list.
     * @param elements An iterable of connectorSuppliedValues elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllConnectorSuppliedValues(Iterable<String> elements) {
      Preconditions.checkNotNull(elements, "connectorSuppliedValues element");
      if (this.connectorSuppliedValues == null) {
        this.connectorSuppliedValues = ImmutableList.builder();
      }
      this.connectorSuppliedValues.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutableAuthParameter ImmutableAuthParameter}.
     * @return An immutable instance of AuthParameter
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableAuthParameter build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableAuthParameter(
          key,
          required,
          label,
          description,
          sensitiveField,
          connectorSuppliedValues == null ? null : connectorSuppliedValues.build());
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_KEY) != 0) attributes.add("key");
      if ((initBits & INIT_BIT_REQUIRED) != 0) attributes.add("required");
      if ((initBits & INIT_BIT_LABEL) != 0) attributes.add("label");
      if ((initBits & INIT_BIT_DESCRIPTION) != 0) attributes.add("description");
      return "Cannot build AuthParameter, some of required attributes are not set " + attributes;
    }
  }
}
