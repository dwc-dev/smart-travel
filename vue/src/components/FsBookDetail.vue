<script setup lang="ts">
import type { ICardItem } from '@/components/type';

const props = defineProps<{
  show: boolean;
  elRect: DOMRect;
  data: ICardItem | null;
}>();
</script>

<template>
  <Transition>
    <div v-if="props.show" class="fs-book-detail">
      <div class="image">
        <img v-if="data?.imageUrl" :src="data.imageUrl" :alt="data.name" />
      </div>
      <div class="content">
        {{ data }}
      </div>
    </div>
  </Transition>
</template>

<style scoped lang="scss">
.fs-book-detail {
  transform: translate(12.5%, 12.5%);
  width: 80%;
  height: 80%;
  display: flex;
  overflow: hidden;
  border: 1px solid #eee;
  border-radius: 20px;
  background-color: white;

  .image {
    width: 65%;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: #f7f7f7;
  }

  .content {
    flex: 1;
    width: 0;
    padding: 1rem;
  }
}

.v-enter-active,
.v-leave-active {
  transition:
    transform 0.4s ease 0s,
    height 0.4s ease 0s,
    width 0.4s ease 0s,
    opacity 0.4s ease 0s;
}

.v-enter-from,
.v-leave-to {
  transform: translate(
    v-bind('props.elRect.left + "px"'),
    v-bind('props.elRect.top + "px"')
  );
  width: v-bind('props.elRect.width + "px"');
  height: v-bind('props.elRect.height + "px"');
  opacity: 0.3;
}
</style>
