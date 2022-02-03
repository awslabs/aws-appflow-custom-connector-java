package com.amazonaws.appflow.custom.connector.model.metadata;

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
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link EntityDefinition}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableEntityDefinition.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableEntityDefinition
    implements EntityDefinition {
  private final Entity entity;
  private final ImmutableList<FieldDefinition> fields;
  private final @Nullable ImmutableMap<String, String> customProperties;

  private ImmutableEntityDefinition(
      Entity entity,
      ImmutableList<FieldDefinition> fields,
      @Nullable ImmutableMap<String, String> customProperties) {
    this.entity = entity;
    this.fields = fields;
    this.customProperties = customProperties;
  }

  /**
   * Contains its name, description, label or if it has child properties or not.
   */
  @JsonProperty("entity")
  @Override
  public Entity entity() {
    return entity;
  }

  /**
   * List of data models of the fields an Entity has.
   */
  @JsonProperty("fields")
  @Override
  public ImmutableList<FieldDefinition> fields() {
    return fields;
  }

  /**
   * Custom properties defined for an Entity.
   */
  @JsonProperty("customProperties")
  @Override
  public @Nullable ImmutableMap<String, String> customProperties() {
    return customProperties;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link EntityDefinition#entity() entity} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param entity A new value for entity
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEntityDefinition withEntity(Entity entity) {
    if (this.entity == entity) return this;
    Entity newValue = Preconditions.checkNotNull(entity, "entity");
    return new ImmutableEntityDefinition(newValue, this.fields, this.customProperties);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link EntityDefinition#fields() fields}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableEntityDefinition withFields(FieldDefinition... elements) {
    ImmutableList<FieldDefinition> newValue = ImmutableList.copyOf(elements);
    return new ImmutableEntityDefinition(this.entity, newValue, this.customProperties);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link EntityDefinition#fields() fields}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of fields elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableEntityDefinition withFields(Iterable<? extends FieldDefinition> elements) {
    if (this.fields == elements) return this;
    ImmutableList<FieldDefinition> newValue = ImmutableList.copyOf(elements);
    return new ImmutableEntityDefinition(this.entity, newValue, this.customProperties);
  }

  /**
   * Copy the current immutable object by replacing the {@link EntityDefinition#customProperties() customProperties} map with the specified map.
   * Nulls are not permitted as keys or values.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param customProperties The entries to be added to the customProperties map
   * @return A modified copy of {@code this} object
   */
  public final ImmutableEntityDefinition withCustomProperties(@Nullable Map<String, ? extends String> customProperties) {
    if (this.customProperties == customProperties) return this;
    @Nullable ImmutableMap<String, String> newValue = customProperties == null ? null : ImmutableMap.copyOf(customProperties);
    return new ImmutableEntityDefinition(this.entity, this.fields, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableEntityDefinition} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableEntityDefinition
        && equalTo((ImmutableEntityDefinition) another);
  }

  private boolean equalTo(ImmutableEntityDefinition another) {
    return entity.equals(another.entity)
        && fields.equals(another.fields)
        && Objects.equal(customProperties, another.customProperties);
  }

  /**
   * Computes a hash code from attributes: {@code entity}, {@code fields}, {@code customProperties}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + entity.hashCode();
    h = h * 17 + fields.hashCode();
    h = h * 17 + Objects.hashCode(customProperties);
    return h;
  }

  /**
   * Prints the immutable value {@code EntityDefinition} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("EntityDefinition")
        .omitNullValues()
        .add("entity", entity)
        .add("fields", fields)
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
  static final class Json implements EntityDefinition {
    @Nullable Entity entity;
    List<FieldDefinition> fields = ImmutableList.of();
    @Nullable Map<String, String> customProperties;
    @JsonProperty("entity")
    public void setEntity(Entity entity) {
      this.entity = entity;
    }
    @JsonProperty("fields")
    public void setFields(List<FieldDefinition> fields) {
      this.fields = fields;
    }
    @JsonProperty("customProperties")
    public void setCustomProperties(@Nullable Map<String, String> customProperties) {
      this.customProperties = customProperties;
    }
    @Override
    public Entity entity() { throw new UnsupportedOperationException(); }
    @Override
    public List<FieldDefinition> fields() { throw new UnsupportedOperationException(); }
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
  static ImmutableEntityDefinition fromJson(Json json) {
    ImmutableEntityDefinition.Builder builder = ImmutableEntityDefinition.builder();
    if (json.entity != null) {
      builder.entity(json.entity);
    }
    if (json.fields != null) {
      builder.addAllFields(json.fields);
    }
    if (json.customProperties != null) {
      builder.putAllCustomProperties(json.customProperties);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link EntityDefinition} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable EntityDefinition instance
   */
  public static ImmutableEntityDefinition copyOf(EntityDefinition instance) {
    if (instance instanceof ImmutableEntityDefinition) {
      return (ImmutableEntityDefinition) instance;
    }
    return ImmutableEntityDefinition.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableEntityDefinition ImmutableEntityDefinition}.
   * @return A new ImmutableEntityDefinition builder
   */
  public static ImmutableEntityDefinition.Builder builder() {
    return new ImmutableEntityDefinition.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableEntityDefinition ImmutableEntityDefinition}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ENTITY = 0x1L;
    private long initBits = 0x1L;

    private @Nullable Entity entity;
    private ImmutableList.Builder<FieldDefinition> fields = ImmutableList.builder();
    private ImmutableMap.Builder<String, String> customProperties = null;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code EntityDefinition} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(EntityDefinition instance) {
      Preconditions.checkNotNull(instance, "instance");
      entity(instance.entity());
      addAllFields(instance.fields());
      @Nullable Map<String, String> customPropertiesValue = instance.customProperties();
      if (customPropertiesValue != null) {
        putAllCustomProperties(customPropertiesValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link EntityDefinition#entity() entity} attribute.
     * @param entity The value for entity 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entity(Entity entity) {
      this.entity = Preconditions.checkNotNull(entity, "entity");
      initBits &= ~INIT_BIT_ENTITY;
      return this;
    }

    /**
     * Adds one element to {@link EntityDefinition#fields() fields} list.
     * @param element A fields element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addFields(FieldDefinition element) {
      this.fields.add(element);
      return this;
    }

    /**
     * Adds elements to {@link EntityDefinition#fields() fields} list.
     * @param elements An array of fields elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addFields(FieldDefinition... elements) {
      this.fields.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link EntityDefinition#fields() fields} list.
     * @param elements An iterable of fields elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder fields(Iterable<? extends FieldDefinition> elements) {
      this.fields = ImmutableList.builder();
      return addAllFields(elements);
    }

    /**
     * Adds elements to {@link EntityDefinition#fields() fields} list.
     * @param elements An iterable of fields elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllFields(Iterable<? extends FieldDefinition> elements) {
      this.fields.addAll(elements);
      return this;
    }

    /**
     * Put one entry to the {@link EntityDefinition#customProperties() customProperties} map.
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
     * Put one entry to the {@link EntityDefinition#customProperties() customProperties} map. Nulls are not permitted
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
     * Sets or replaces all mappings from the specified map as entries for the {@link EntityDefinition#customProperties() customProperties} map. Nulls are not permitted as keys or values, but parameter itself can be null
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
     * Put all mappings from the specified map as entries to {@link EntityDefinition#customProperties() customProperties} map. Nulls are not permitted
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
     * Builds a new {@link ImmutableEntityDefinition ImmutableEntityDefinition}.
     * @return An immutable instance of EntityDefinition
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableEntityDefinition build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableEntityDefinition(entity, fields.build(), customProperties == null ? null : customProperties.build());
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_ENTITY) != 0) attributes.add("entity");
      return "Cannot build EntityDefinition, some of required attributes are not set " + attributes;
    }
  }
}
