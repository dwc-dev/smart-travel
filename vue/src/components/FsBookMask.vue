<script setup lang="ts">
const props = defineProps<{ show: boolean }>();
const emit = defineEmits(['close']);

const handleMaskClick = (event: MouseEvent) => {
  if (event.target === event.currentTarget) {
    emit('close');
  }
};
</script>

<template>
  <Transition>
    <div v-show="props.show" class="fs-book-mask" @click="handleMaskClick">
      <slot />
    </div>
  </Transition>
</template>

<style scoped lang="scss">
.fs-book-mask {
  position: fixed;
  left: 0;
  top: 0;
  width: 100vw;
  height: 100vh;
  z-index: 20;
  background: rgba(0, 0, 0, 0.25);
}

.v-enter-active,
.v-leave-active {
  transition: background-color 0.4s ease 0s;
}

.v-enter-from,
.v-leave-to {
  background-color: transparent;
}
</style>
