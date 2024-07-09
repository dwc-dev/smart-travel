<script setup lang="ts">
import { navigateToBuyPage } from '@/api/api';
import type { ICardItem } from '@/components/type';

const props = defineProps<{
  show: boolean;
  elRect: DOMRect;
  data: ICardItem | null;
}>();

const handleBuyButtonClick = () => {
  if (props.data?.id) {
    navigateToBuyPage(props.data.id);
  }
};
</script>

<template>
  <Transition>
    <div v-if="show" class="fs-book-detail">
      <div class="image">
        <img
          v-if="data?.imageUrl"
          class="w-full"
          :src="data.imageUrl"
          :alt="data.name"
        />
      </div>
      <div class="content">
        <template v-if="data?.name">
          <h1>{{ data.name }}</h1>
        </template>
        <template v-if="data?.address">
          <h2>{{ data.address }}</h2>
        </template>
        <template v-if="data?.description">
          <p>{{ data.description }}</p>
        </template>

        <button class="buy-button" @click="handleBuyButtonClick">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="32"
            height="32"
            viewBox="0 0 256 256"
          >
            <path
              fill="currentColor"
              d="m239.71 74.14l-25.64 92.28A24.06 24.06 0 0 1 191 184H92.16A24.06 24.06 0 0 1 69 166.42L33.92 40H16a8 8 0 0 1 0-16h24a8 8 0 0 1 7.71 5.86L57.19 64H232a8 8 0 0 1 7.71 10.14M88 200a16 16 0 1 0 16 16a16 16 0 0 0-16-16m104 0a16 16 0 1 0 16 16a16 16 0 0 0-16-16"
            />
          </svg>
          <span>购票</span>
        </button>
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
    position: relative;
    overflow-y: scroll;

    &::-webkit-scrollbar {
      display: none;
    }

    h1 {
      margin-top: 20px;
      color: #f69;
      text-align: center;
      font-size: 22px;
      font-weight: bold;
      text-wrap: nowrap;
    }

    h2 {
      margin-top: 10px;
      margin-bottom: 10px;
      font-family: '华文行楷', 'Microsoft YaHei UI', sans-serif;
      text-align: right;
      font-size: 16px;
      text-wrap: nowrap;
    }

    p {
      text-indent: 2em;
    }

    .buy-button {
      position: absolute;
      bottom: 20px;
      right: 20px;
      padding: 7px 15px;
      display: flex;
      align-items: center;
      justify-content: center;
      color: white;
      font-size: 12px;
      font-weight: 500;
      line-height: 1;
      border-radius: 20px;
      box-sizing: border-box;
      background-color: #fb7299;
      outline: 0;
      transition: 0.1s;
      cursor: pointer;

      &:hover {
        background-color: #fc8bab;
      }

      svg {
        width: 16px;
        height: 16px;
        margin-right: 8px;
      }
    }
  }
}

.v-enter-active,
.v-leave-active {
  transition: all 0.4s ease 0s;
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
